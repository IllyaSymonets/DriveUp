package softserve.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softserve.academy.domain.PaymentDetails;
import softserve.academy.dto.CreatePaymentDetails;
import softserve.academy.repos.PaymentDetailsRepo;

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
