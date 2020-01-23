package com.driveUp.services;

import com.driveUp.models.Fund;
import com.driveUp.repositories.FundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FundService {
    private final FundRepository fundRepository;

    public List<Fund> getAllFunds() {
        return fundRepository.findAll();
    }

    public void addFund(UUID driverId) {
        Fund fund = new Fund(driverId, BigDecimal.valueOf(100));
        fundRepository.save(fund);
    }
}