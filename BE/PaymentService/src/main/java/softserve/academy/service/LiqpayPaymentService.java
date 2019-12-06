package softserve.academy.service;

import org.springframework.stereotype.Service;
import softserve.academy.domain.Payment;
import softserve.academy.domain.Transaction;
import softserve.academy.repos.TransactionRepo;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
public class LiqpayPaymentService extends PaymentService {

    public LiqpayPaymentService(TransactionRepo transactionRepo) {
        super(transactionRepo);
    }

    @Transactional
    @Override
    public Payment payOnline(Payment payment) {
        transactionRepo.save(payment.getTransaction());
        Transaction tempTransaction = transactionRepo.findById(
                payment.getTransaction().getId()).get();
        String htmlText = makeHtml(payment);
        /*if(res.get("status").equals("success")){
            payment.setSuccessful(true);
            tempTransaction.setStatus(TransactionStatus.successful);
        }else{tempTransaction.setStatus(TransactionStatus.unsuccessful);}*/
        return payment;
    }

    private String makeHtml(Payment payment) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("action", "pay");
        params.put("amount", String.valueOf(payment.getTransaction().getSummary()));
        params.put("currency", "UAH");
        params.put("description", "description text");
        params.put("order_id", payment.getTransaction().getId().toString());
        params.put("version", "3");
        params.put("paytypes", payment.getLiqpayPaymentType().getLiqpayTitle());
        /*LiqPay liqpay = new LiqPay(PUBLIC_KEY, PRIVATE_KEY);
        String html = liqpay.cnb_form(params);
        System.out.println(html);*/
        return /*html*/"";
    }
}
