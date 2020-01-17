package com.zaets39.billing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Entity
@Table(name = "bills")
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NonNull
    private double amount;
    @NotBlank
    private String paymentMode;
    private UUID orderId;
    private UUID driverId;
    private  boolean paid;

    public Bill(@JsonProperty("orderId") UUID orderId,
                @JsonProperty("driverId") UUID driverId,
                @JsonProperty("amount") double amount,
                @JsonProperty("paymentMode") String paymentMode,
                @JsonProperty("paid") boolean paid) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paid = paid;
    }
}
