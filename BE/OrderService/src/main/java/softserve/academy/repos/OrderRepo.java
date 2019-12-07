package softserve.academy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import softserve.academy.domain.Order;
import softserve.academy.domain.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {

    List<Order> findAllByStatus(OrderStatus status);

    List<Order> findAllByDriverId(UUID driverId);

    List<Order> findAllByCustomerId(UUID customerId);
}
