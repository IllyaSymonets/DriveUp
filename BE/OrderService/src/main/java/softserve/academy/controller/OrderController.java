package softserve.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softserve.academy.domain.Order;
import softserve.academy.domain.OrderStatus;
import softserve.academy.request.CreateOrder;
import softserve.academy.repos.OrderRepo;

import java.util.List;
import java.util.UUID;

@RestController("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;

    @PostMapping("create")
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrder createOrder) {
        Order order = new Order(createOrder);
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }

    @PutMapping("setDriver")
    public ResponseEntity<Order> setDriverToOrder(@RequestParam UUID orderId,
                                                  @RequestParam UUID driverId) {
        Order order = orderRepo.findById(orderId).get();
        order.setDriverId(driverId);
        return new ResponseEntity<>(orderRepo.save(order), HttpStatus.OK);
    }

    @PutMapping("updateStatus")
    public ResponseEntity<Order> updateStatusToOrder(@RequestParam UUID orderId,
                                                     @RequestParam OrderStatus status) {
        Order order = orderRepo.findById(orderId).get();
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
}
