package com.driveUp.service;

import com.driveUp.domain.PaymentDetails;
import com.driveUp.dto.CreatePaymentDetails;
import com.driveUp.repos.PaymentDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentDetailsService {

    private final PaymentDetailsRepo paymentDetailsRepo;

    @Transactional
    public PaymentDetails addDetails(CreatePaymentDetails details) {
        PaymentDetails paymentDetails = new PaymentDetails(
                details.getDriverId(), details.getCard(),
                details.getCardName(), details.getCardFamilyName());
        changeActualDetails(paymentDetailsRepo.findByDriverIdAndIsActual(
                paymentDetails.getDriverId(), true), false);
        return paymentDetailsRepo.save(paymentDetails);
    }

    @Transactional
    public PaymentDetails changeActualDetails(PaymentDetails details, boolean isActual) {
        PaymentDetails unActualDetails = paymentDetailsRepo.findById(details.getId()).get();
        unActualDetails.setActual(isActual);
        return paymentDetailsRepo.save(unActualDetails);
    }
}
