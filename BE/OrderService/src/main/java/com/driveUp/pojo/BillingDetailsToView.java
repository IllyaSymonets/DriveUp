package com.driveUp.pojo;

import lombok.Data;
import com.driveUp.domain.PaymentType;

import java.math.BigDecimal;

@Data
public class BillingDetailsToView {
    private BigDecimal price;
    private PaymentType paymentType;
}
