package com.driveUp.controller;

import com.driveUp.service.CustomerNotificationService;
import lombok.RequiredArgsConstructor;
import com.driveUp.dto.ApprovedOrderDto;
import com.driveUp.dto.CreatedOrderDto;
import com.driveUp.model.PhoneNotification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/com/driveUp/customer")
@RequiredArgsConstructor
public class CustomerNotificationController {

    private final CustomerNotificationService customerNotificationService;

    @PostMapping("/order_created")
    public ResponseEntity<PhoneNotification> saveMessageOrderRegistered(@RequestBody CreatedOrderDto createdOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayOrderCreated(createdOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/order_approved")
    public ResponseEntity<PhoneNotification> saveMessageOrderRegistered(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayApprovedOrderMess(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/car_arrived")
    public ResponseEntity<PhoneNotification> saveMessageCarArrived(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayCarArrivedMess(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/trip_started")
    public ResponseEntity<PhoneNotification> saveMessageTripStarted(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayTripStarted(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/trip_finished")
    public ResponseEntity<PhoneNotification> saveMessageTripFinished(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayTripFinished(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/payed_by_cash")
    public ResponseEntity<PhoneNotification> saveMessagePayedByCash(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayPayedByCash(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }

    @PostMapping("/payed_by_bank")
    public ResponseEntity<PhoneNotification> saveMessagePayedByBank(@RequestBody ApprovedOrderDto approvedOrderDto) {
        PhoneNotification phoneNotification = customerNotificationService.sayPayedByBank(approvedOrderDto);
        return new ResponseEntity<>(phoneNotification, HttpStatus.OK);
    }
}
