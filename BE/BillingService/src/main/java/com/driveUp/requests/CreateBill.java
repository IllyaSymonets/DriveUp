package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBill {
    @Positive
    @Min(33)
    private BigDecimal amount;
    @Positive
    @Min(1)
    private double distance;
    @NotBlank
    private String paymentMode;
}