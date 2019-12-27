package com.zaets39.billing.services;

import com.zaets39.billing.models.Fund;
import com.zaets39.billing.pojo.SalaryPaid;
import com.zaets39.billing.pojo.WeekPaymentRequest;
import com.zaets39.billing.repositories.FundRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchedulerSalary {

    private FundService fundService;
    private FundRepository fundRepository;

    //    @Scheduled(cron = "0 0 12 * * THU")
//    public void paySalary() {
//        countSalary();
//    }
    private List<WeekPaymentRequest> countSalary() {
        List<Fund> funds = fundService.getAllFunds();
        List<WeekPaymentRequest> salary = new ArrayList<>();
        WeekPaymentRequest currentDriver = new WeekPaymentRequest();
        for (int i = 0; i <= funds.size(); i++) {
            if ((funds.get(i).getFundBalance() - 100) > 0) {
                currentDriver.setDriverId(funds.get(i).getDriverId());
                currentDriver.setSalary(funds.get(i).getFundBalance() - 100);
            }
        }
        return salary;
    }

    public void bankResult(List<SalaryPaid> resultFromBank) {
        for (int i = 0; i < resultFromBank.size(); i++) {
            Fund currentFund = fundRepository.findByDriverId(resultFromBank.get(i).getDriverId());
            if (resultFromBank.get(i).isTransactionResult()) {
                currentFund.setFundBalance(100);
                fundRepository.save(currentFund);
            }
        }
    }
}