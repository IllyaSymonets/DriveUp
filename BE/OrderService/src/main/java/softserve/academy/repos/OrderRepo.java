package softserve.academy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import softserve.academy.domain.Order;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
}
