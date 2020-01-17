package com.zaets39.billing.services;

import com.zaets39.billing.models.Fund;
import com.zaets39.billing.requests.FundRequest;
import com.zaets39.billing.repositories.FundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class FundService {
    private final FundRepository fundRepository;

    public List<Fund> getAllFunds() {
        return fundRepository.findAll();
    }

    public Fund addFund(FundRequest fundRequest) {
        Fund fund = new Fund(fundRequest.getDriverId(), BigDecimal.valueOf(100));
        fundRepository.save(fund);
        return fund;
    }
}