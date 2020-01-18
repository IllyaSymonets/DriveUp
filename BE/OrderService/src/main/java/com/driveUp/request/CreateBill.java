package com.driveUp.request;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBill {
    private BigDecimal amount;
    private double distance;
    private String paymentMode;
}