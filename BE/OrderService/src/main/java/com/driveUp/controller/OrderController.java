package com.driveUp.controller;

import com.driveUp.domain.Order;
import com.driveUp.domain.OrderStatus;
import com.driveUp.repos.OrderRepo;
import com.driveUp.request.*;
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
    private final KafkaTemplate<String, CreateTripRequest> kafkaCreateTripTemplate;
    private final KafkaTemplate<String, CreateBillRequest> kafkaCreateBillTemplate;
    private final String CREATE_TRIP_TOPIC="CREATE_TRIP_EVENT";
    private final String CREATE_BILL_TOPIC="CREATE_BILL_EVENT";

    @PostMapping("add")
    public ResponseEntity<Long> createOrder(@RequestBody CreateOrder createOrder) {
        Order order = new Order(createOrder.getOrderType(), createOrder.getDate());
        orderRepo.save(order);
        kafkaCreateTripTemplate.send(CREATE_TRIP_TOPIC, new CreateTripRequest(order.getOrderNumber(), createOrder.getTripInfo()));
        kafkaCreateBillTemplate.send(CREATE_BILL_TOPIC, new CreateBillRequest(order.getOrderNumber(), createOrder.getBillInfo()));
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

    @KafkaListener(topics = "SET_TRIP_EVENT", containerFactory = "kafkaSetTripListenerContainerFactory")
    public void setTripId(@RequestBody SetTripToOrderRequest setTripToOrderRequest){
        Order order = orderRepo.findById(setTripToOrderRequest.getOrderNumber()).get();
        order.setTripId(setTripToOrderRequest.getTripId());
        orderRepo.save(order);
    }

    @KafkaListener(topics = "SET_BILL_EVENT", containerFactory = "kafkaSetBillListenerContainerFactory")
    public void setTripId(@RequestBody SetBillToOrderRequest setBillToOrderRequest){
        Order order = orderRepo.findById(setBillToOrderRequest.getOrderNumber()).get();
        order.setBillId(setBillToOrderRequest.getBillId());
        orderRepo.save(order);
    }
}
