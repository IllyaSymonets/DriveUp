package com.driveUp.requests;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class BillingDetailsToView {
    private BigDecimal price;
    private String paymentType;
}

