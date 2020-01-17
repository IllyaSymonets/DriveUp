package com.zaets39.billing.controllers;

import com.zaets39.billing.models.Bill;
import com.zaets39.billing.requests.BillRequest;
import com.zaets39.billing.requests.ComfortFromUI;
import com.zaets39.billing.services.BillingService;
import com.zaets39.billing.utils.BillUtils;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class BillingController {

    private final BillingService billingService;
    @LoadBalanced
    private RestTemplate restTemplate;

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
    @GetMapping("/countPrice")
    public ResponseEntity<BigDecimal> countPrice(ComfortFromUI comfortFromUI, double distance) {
//        DistanceRequest distance = restTemplate.getForObject("http://driveUp-brain-service/distanceForBill/",
//                DistanceRequest.class);
        BigDecimal amount = BillUtils.countPrice(comfortFromUI, distance);
        return new ResponseEntity<>(amount, HttpStatus.OK);
    }
}