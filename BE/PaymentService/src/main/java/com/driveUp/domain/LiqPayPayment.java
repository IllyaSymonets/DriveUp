package softserve.academy.domain;

public class LiqPayPayment extends Payment {

    LiqpayPaymentType liqpayPaymentType;

    public LiqPayPayment(Transaction transaction, PaymentDetails paymentDetails) {
        super(transaction, paymentDetails);
    }

    public LiqPayPayment(Transaction transaction, LiqpayPaymentType liqpayPaymentType) {
        super(transaction);
        this.liqpayPaymentType = liqpayPaymentType;
    }
}
