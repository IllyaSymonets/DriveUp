package com.driveUp.controller;

import com.driveUp.domain.Order;
import com.driveUp.domain.OrderStatus;
import com.driveUp.repos.OrderRepo;
import com.driveUp.requests.*;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;
    private final Gson jsonConverter;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> showAllBills() {
        List<Order> orders = orderRepo.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Long> createOrder(@RequestBody CreateOrder createOrder) {
        Order order = new Order(createOrder.getOrderType(), createOrder.getDate());
        orderRepo.save(order);


        CreateTripRequest createTripRequest = new CreateTripRequest(order.getOrderNumber(), createOrder.getTripInfo());
        CreateBillRequest createBillRequest = new CreateBillRequest(order.getOrderNumber(), createOrder.getBillInfo());

        kafkaTemplate.send("CREATE_TRIP_EVENT", jsonConverter.toJson(createTripRequest));
        kafkaTemplate.send("CREATE_BILL_EVENT", jsonConverter.toJson(createBillRequest));
        return new ResponseEntity<>(order.getOrderNumber(), HttpStatus.OK);
    }

    @PutMapping("setDriver")
    public ResponseEntity<Order> setDriverToOrder(@RequestParam long orderNumber,
                                                  @RequestParam UUID driverId) {
        Order order = orderRepo.findById(orderNumber).get();
        order.setDriverId(driverId);
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }

    @PutMapping("updateStatus")
    public ResponseEntity<Order> updateStatusToOrder(@RequestParam long orderNumber,
                                                     @RequestParam OrderStatus status) {
        Order order = orderRepo.findById(orderNumber).get();
        order.setStatus(status);
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }

    @GetMapping("getByStatus")
    public ResponseEntity<List<Order>> getByStatus(
            @RequestParam OrderStatus status) {
        return new ResponseEntity<>(orderRepo.findAllByStatus(status),
                HttpStatus.OK);
    }

    @GetMapping("getByDriverId")
    public ResponseEntity<List<Order>> getByDriverId(
            @RequestParam UUID driverId) {
        return new ResponseEntity<>(orderRepo.findAllByDriverId(driverId),
                HttpStatus.OK);
    }

    @GetMapping("getByCustomerId")
    public ResponseEntity<List<Order>> getByCustomerId(
            @RequestParam UUID customerId) {
        return new ResponseEntity<>(orderRepo.findAllByCustomerId(customerId),
                HttpStatus.OK);
    }

    @KafkaListener(topics = "SET_TRIP_EVENT")
    public void setTripId(String setTripToOrderRequest) {
        SetTripToOrderRequest tripToOrderRequest = jsonConverter.fromJson(
                setTripToOrderRequest, SetTripToOrderRequest.class);

        Order order = orderRepo.findById(tripToOrderRequest.getOrderNumber()).get();
        order.setTripId(tripToOrderRequest.getTripId());
        orderRepo.save(order);
    }

    @KafkaListener(topics = "SET_BILL_EVENT")
    public void setBillId(String setBillToOrderRequest) {
        SetBillToOrderRequest billToOrderRequest = jsonConverter.fromJson(
              setBillToOrderRequest, SetBillToOrderRequest.class);

        Order order = orderRepo.findById(billToOrderRequest.getOrderNumber()).get();
        order.setBillId(billToOrderRequest.getBillId());
        orderRepo.save(order);
    }
}
