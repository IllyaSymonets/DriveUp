package softserve.academy.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Payment {

    Transaction transaction;
    PaymentDetails paymentDetails;
    boolean isSuccessful = false;


    public Payment(Transaction transaction, PaymentDetails paymentDetails) {
        this.transaction = transaction;
        this.paymentDetails = paymentDetails;
    }

    public Payment(Transaction transaction) {
        this.transaction = transaction;
    }
}
