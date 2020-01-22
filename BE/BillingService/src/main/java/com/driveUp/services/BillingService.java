package com.driveUp.services;

import com.driveUp.constants.ConstantValues;
import com.driveUp.models.Bill;
import com.driveUp.models.Fund;
import com.driveUp.repositories.BillRepository;
import com.driveUp.repositories.FundRepository;
import com.driveUp.requests.CreateBill;
import com.driveUp.requests.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Bill processBill(CreateBill billRequest) {
        BigDecimal appPercent = ConstantValues.APPLICATION_PERCENT.multiply(billRequest.getAmount());
        BigDecimal driverPercent = ConstantValues.DRIVER_PERCENT.multiply(billRequest.getAmount());
        boolean paid = false;
        UUID driverId = getRandomDriver();
        Fund currentDriver = fundRepository.findByDriverId(driverId);
        paid = isPaid(billRequest, appPercent, driverPercent, paid, currentDriver);
        Bill bill = new Bill(currentDriver.getDriverId(),
                billRequest.getAmount(), billRequest.getPaymentMode(), paid);
        billRepository.save(bill);
        return bill;
    }

    private boolean isPaid(CreateBill billRequest, BigDecimal appPercent,
                           BigDecimal driverPercent, boolean paid, Fund currentDriver) {
        if (billRequest.getPaymentMode().equalsIgnoreCase(ConstantValues.CARD_PAYMENT)) {
            PaymentRequest payment = new PaymentRequest(billRequest.getAmount());
            boolean bankAnswer = bankStub(payment);
            if (bankAnswer) {
                processCardPayment(currentDriver, driverPercent);
                paid = true;
                fundRepository.save(currentDriver);
            }
        } else if (billRequest.getPaymentMode().equalsIgnoreCase(ConstantValues.CASH_PAYMENT)) {
            paid = processCashPayment(currentDriver, appPercent);
        }
        return paid;
    }

    private void processCardPayment(Fund currentDriver, BigDecimal driverPercent) {
        BigDecimal newBalance = currentDriver.getFundBalance().add(driverPercent);
        currentDriver.setFundBalance(newBalance);
    }

    private boolean processCashPayment(Fund currentDriver, BigDecimal appPercent) {
        boolean result;
        if (currentDriver.getFundBalance().compareTo(appPercent) < 1) {
            result = false;
        } else {
            BigDecimal newBalance = currentDriver.getFundBalance().subtract(appPercent);
            currentDriver.setFundBalance(newBalance);
            result = true;
        }
        return result;
    }

    private boolean bankStub(PaymentRequest paymentRequest) {
        return paymentRequest.getAmount().compareTo(BigDecimal.valueOf(0.00)) > 0;
    }

    private UUID getRandomDriver() {
        List<Fund> allFunds = fundRepository.findAll();
        Random random = new Random();
        return allFunds.get(random.nextInt(allFunds.size())).getDriverId();
    }
}