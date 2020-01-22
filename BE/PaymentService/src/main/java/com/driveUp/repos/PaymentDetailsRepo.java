package softserve.academy.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import softserve.academy.domain.PaymentDetails;

import java.util.UUID;

public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, UUID> {
    PaymentDetails findByDriverIdAndIsActual(UUID driverId, boolean isActual);
}
