package com.driveUp.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class BillRequest {
    private BigDecimal  amount;
    @NonNull
    private double distance;
    @NotBlank
    private String paymentMode;

    public BillRequest(@JsonProperty("distance") double distance,
                       @JsonProperty("paymentMode") String paymentMode,
                       @JsonProperty("amount") BigDecimal amount) {
        this.distance = distance;
        this.paymentMode = paymentMode;
        this.amount = amount;
    }
}