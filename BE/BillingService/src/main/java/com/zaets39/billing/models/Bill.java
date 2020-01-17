package com.zaets39.billing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "bills")
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private BigDecimal amount;
    @NotBlank
    private String paymentMode;
    private UUID driverId;
    private boolean paid;

    public Bill(@JsonProperty("driverId") UUID driverId,
                @JsonProperty("amount") BigDecimal amount,
                @JsonProperty("paymentMode") String paymentMode,
                @JsonProperty("paid") boolean paid) {
        this.driverId = driverId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paid = paid;
    }
}
