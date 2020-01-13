package com.driveUp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.driveUp.domain.Order;
import com.driveUp.domain.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {

    List<Order> findAllByStatus(OrderStatus status);

    List<Order> findAllByDriverId(UUID driverId);

    List<Order> findAllByCustomerId(UUID customerId);
}
