package softserve.academy.request;

import lombok.Data;
import softserve.academy.domain.PaymentType;

import java.math.BigDecimal;

@Data
public class BillingDetailsToView {
    private BigDecimal price;
    private PaymentType paymentType;
}
