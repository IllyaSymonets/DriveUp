package com.driveUp.controllers;

import com.driveUp.models.Bill;
import com.driveUp.requests.ComfortFromUI;
import com.driveUp.requests.CreateBillRequest;
import com.driveUp.requests.SetBillToOrderRequest;
import com.driveUp.services.BillingService;
import com.driveUp.utils.BillUtils;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class BillingController {

    private final BillingService billingService;
    //    @LoadBalanced
//    private RestTemplate restTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;


    @GetMapping("/allBills")
    public ResponseEntity<List<Bill>> showAllBills() {
        List<Bill> bills = billingService.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @KafkaListener(topics = "CREATE_BILL_EVENT")
    public ResponseEntity<Bill> add(String createBillRequest) {

        CreateBillRequest billRequestObject = jsonConverter.fromJson(
                createBillRequest, CreateBillRequest.class);

        Bill bill = billingService.processBill(billRequestObject.getBillInfo());

        SetBillToOrderRequest billToOrderRequest = new SetBillToOrderRequest(
                billRequestObject.getOrderNumber(), bill.getId());

        kafkaTemplate.send("SET_BILL_EVENT", jsonConverter.toJson(billToOrderRequest));
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping("/countPrice")

    public ResponseEntity<BigDecimal> countPrice(@RequestBody @Valid ComfortFromUI comfortFromUI){
        BigDecimal amount = BillUtils.countPrice(comfortFromUI);
        return new ResponseEntity<>(amount, HttpStatus.OK);
    }
}