package com.driveUp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "bills")
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Positive
    @Min(33)
    private BigDecimal amount;
    @NotBlank
    private String paymentMode;
    private UUID driverId;
    private boolean paid;

    public Bill(UUID driverId, BigDecimal amount, String paymentMode,
                boolean paid) {
        this.driverId = driverId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paid = paid;
    }
}
