package com.driveUp.services;

import com.driveUp.pojo.CreateBill;
import com.driveUp.pojo.PaymentRequest;
import com.driveUp.repositories.BillRepository;
import com.driveUp.repositories.FundRepository;
import com.driveUp.models.Bill;
import com.driveUp.models.Fund;
import com.driveUp.utils.BillUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BillingService {

    private final BillRepository billRepository;
    private final FundRepository fundRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill processBill(CreateBill createBill) {
        double amount = BillUtils.countPrice(createBill);
        double appPercent = 0.12 * amount;
        double driverPercent = 0.88 * amount;
        boolean paid = false;
        UUID driverId = getRandomDriver();
        Fund currentDriver = fundRepository.findByDriverId(driverId);
        if (createBill.getPaymentMode().equalsIgnoreCase("CARD")) {
            PaymentRequest payment = new PaymentRequest(amount);
            boolean bankAnswer = bankStub(payment);
            if (bankAnswer) {
                processCardPayment(currentDriver, driverPercent);
                paid = true;
                fundRepository.save(currentDriver);
            } else {
                paid = false;
            }
        }
        if (createBill.getPaymentMode().equalsIgnoreCase("CASH")) {
            paid = processCashPayment(currentDriver, appPercent);
        }
        Bill bill = new Bill(currentDriver.getDriverId(),
                amount, createBill.getPaymentMode(), paid);
        billRepository.save(bill);
        return bill;
    }

    private void processCardPayment(Fund currentDriver, double driverPercent) {
        double newBalance = currentDriver.getFundBalance() + driverPercent;
        currentDriver.setFundBalance(newBalance);
    }

    private boolean processCashPayment(Fund currentDriver, double appPercent) {
        boolean result;
        if (currentDriver.getFundBalance() < appPercent) {
            result = false;
        } else {
            double newBalance = currentDriver.getFundBalance() - appPercent;
            currentDriver.setFundBalance(newBalance);
            result = true;
        }
        return result;
    }

    private boolean bankStub(PaymentRequest paymentRequest) {
        return paymentRequest.getAmount() > 0;
    }

    private UUID getRandomDriver() {
        List<Fund> allFunds = fundRepository.findAll();
        Random random = new Random();
        return allFunds.get(random.nextInt(allFunds.size())).getDriverId();
    }
}