package com.zaets39.billing.controllers;

import com.zaets39.billing.models.Fund;
import com.zaets39.billing.pojo.FundRequest;
import com.zaets39.billing.services.FundService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FundController {
    private final FundService fundService;

    @GetMapping("/allFunds")
    public ResponseEntity<List<Fund>> showAllFunds() {
        List<Fund> funds = fundService.getAllFunds();
        return new ResponseEntity<>(funds, HttpStatus.OK);
    }

    @PostMapping("/addFund")
    public ResponseEntity<Fund> add(@RequestBody FundRequest fundRequest) {
        Fund fund = fundService.addFund(fundRequest);
        return new ResponseEntity<>(fund, HttpStatus.OK);
    }
}
