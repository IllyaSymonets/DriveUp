package com.driveUp.controller;

import com.driveUp.domain.Transaction;
import com.driveUp.repos.TransactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepo transactionRepo;

    @GetMapping("getTransactions")
    public Iterable<Transaction> changeActualDetails() {
        return transactionRepo.findAll();
    }
}
