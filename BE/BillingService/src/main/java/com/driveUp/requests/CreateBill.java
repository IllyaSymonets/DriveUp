package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBill {
    private BigDecimal  amount;
    @NonNull
    private double distance;
    @NotBlank
    private String paymentMode;
}