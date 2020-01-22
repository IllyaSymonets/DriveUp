package com.driveUp.service;

import com.driveUp.domain.Payment;
import com.driveUp.domain.Transaction;
import com.driveUp.repos.TransactionRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
//@PropertySource("classpath:paymentAccountsInfo.properties")
public abstract class PaymentService {

    protected final TransactionRepo transactionRepo;
    //@Value("${liqpay.PUBLIC_KEY}")
    String PUBLIC_KEY;
    //@Value("${liqpay.PRIVATE_KEY}")
    String PRIVATE_KEY;
    @Getter
    //@Value("${liqpay.ID}")
    UUID companyId;

    @Transactional
    public Payment payToDriver(Payment payment) {
        transactionRepo.save(payment.getTransaction());
        Transaction tempTransaction = transactionRepo.findById(
                payment.getTransaction().getId()).get();
        /*Map<String, Object> res = */
        sendRequestLiqPay(payment);//.api("request", params);
        /*if(res.get("status").equals("success")){
            payment.setSuccessful(true);
            tempTransaction.setStatus(TransactionStatus.successful);
        }else{tempTransaction.setStatus(TransactionStatus.unsuccessful);}*/
        transactionRepo.save(tempTransaction);
        return payment;
    }

    @Transactional
    abstract public Payment payOnline(Payment payment);

    private void /*LiqPay*/ sendRequestLiqPay(Payment payment) {
        HashMap<String, String> params = new HashMap<>();
        params.put("action", "p2pcredit");
        params.put("version", "3");
        params.put("amount", String.valueOf(payment.getTransaction().getSummary()));
        params.put("currency", "UAH");
        params.put("description", "Driver payment");
        params.put("order_id", payment.getTransaction().getId().toString());
        params.put("receiver_card", payment.getPaymentDetails().getCard());
        params.put("receiver_last_name", payment.getPaymentDetails().getCardFamilyName());
        params.put("receiver_first_name", payment.getPaymentDetails().getCardName());
        //return new LiqPay(PUBLIC_KEY, PRIVATE_KEY);
    }
}
