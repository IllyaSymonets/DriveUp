package softserve.academy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import softserve.academy.domain.Transaction;

import java.util.UUID;

public interface TransactionRepo extends JpaRepository<Transaction, UUID> {
}
