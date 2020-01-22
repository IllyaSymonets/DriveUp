package com.driveUp.repos;


import com.driveUp.domain.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, UUID> {
    PaymentDetails findByDriverIdAndIsActual(UUID driverId, boolean isActual);
}
