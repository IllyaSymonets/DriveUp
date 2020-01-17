package com.driveUp.services;

import com.driveUp.models.Fund;
import com.driveUp.repositories.FundRepository;
import com.driveUp.requests.FundRequest;
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