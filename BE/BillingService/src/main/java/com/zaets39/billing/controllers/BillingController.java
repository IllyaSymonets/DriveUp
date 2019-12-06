package com.zaets39.billing.controllers;

import com.zaets39.billing.models.Bill;
import com.zaets39.billing.pojo.BillRequest;
import com.zaets39.billing.pojo.PaymentRequest;
import com.zaets39.billing.services.BillingService;
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
public class BillingController {

    private final BillingService billingService;

    @GetMapping("/allBills")
    public ResponseEntity<List<Bill>> showAllBills() {
        List<Bill> bills = billingService.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @PostMapping("/addBill")
    public ResponseEntity<Bill> add(@RequestBody BillRequest billRequest) {
        Bill bill = billingService.processBill(billRequest);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}