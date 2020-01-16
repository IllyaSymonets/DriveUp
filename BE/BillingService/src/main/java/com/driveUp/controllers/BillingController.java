package com.driveUp.controllers;

import com.driveUp.models.Bill;
import com.driveUp.pojo.CreateBillRequest;
import com.driveUp.pojo.SetBillToOrderRequest;
import com.driveUp.services.BillingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BillingController {

    private final BillingService billingService;
    private final KafkaTemplate<String, SetBillToOrderRequest> kafkaTemplate;
    private final String SET_BILL_TOPIC="SET_BILL_EVENT";

    @GetMapping("/allBills")
    public ResponseEntity<List<Bill>> showAllBills() {
        List<Bill> bills = billingService.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @PostMapping("/addBill")
    @KafkaListener(topics = "CREATE_BILL_EVENT", containerFactory = "kafkaListenerContainerFactory")
    public ResponseEntity<Bill> add(@RequestBody CreateBillRequest createBillRequest) {
        Bill bill = billingService.processBill(createBillRequest.getBillInfo());
        kafkaTemplate.send(SET_BILL_TOPIC, new SetBillToOrderRequest(
                createBillRequest.getOrderId(), bill.getId()));
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}