package com.driveUp.controller;

import com.driveUp.domain.PaymentDetails;
import com.driveUp.dto.CreatePaymentDetails;
import com.driveUp.repos.PaymentDetailsRepo;
import com.driveUp.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class PaymentDetailsController {

    private final PaymentDetailsService detailsService;
    private final PaymentDetailsRepo detailsRepo;

    @PostMapping("addpaymentDetails")
    public PaymentDetails addDetails(@RequestBody CreatePaymentDetails details) {
        return detailsService.addDetails(details);
    }

    @PutMapping("paymentDetailsChooseActual")
    public PaymentDetails changeActualDetails(@RequestBody PaymentDetails details) {
        detailsService.changeActualDetails(detailsRepo.findByDriverIdAndIsActual(
                details.getDriverId(), true), false);
        return detailsService.changeActualDetails(details, true);
    }

    @GetMapping("getPaymentDetails")
    public Iterable<PaymentDetails> changeActualDetails() {
        return detailsRepo.findAll();
    }
}
