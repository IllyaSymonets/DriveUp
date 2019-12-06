package softserve.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softserve.academy.domain.PaymentDetails;
import softserve.academy.dto.CreatePaymentDetails;
import softserve.academy.repos.PaymentDetailsRepo;
import softserve.academy.service.PaymentDetailsService;

@RestController
@RequiredArgsConstructor
public class PaymentDetailsController {

    private final PaymentDetailsService detailsService;
    private  final PaymentDetailsRepo detailsRepo;

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
