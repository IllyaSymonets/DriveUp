package com.zaets39.billing.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zaets39.billing.constants.cars.CarType;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BillRequest {
    BigDecimal  amount;
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