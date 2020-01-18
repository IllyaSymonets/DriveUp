package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateBill {
    private BigDecimal amount;
    private double distance;
    private String paymentMode;
}

