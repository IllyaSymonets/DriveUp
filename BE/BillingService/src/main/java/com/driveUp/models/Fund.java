package com.driveUp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "funds")
@NoArgsConstructor
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID driverId;
    @Positive
    private BigDecimal fundBalance;

    public Fund(UUID driverId, BigDecimal fundBalance) {
        this.driverId = driverId;
        this.fundBalance = fundBalance;
    }
}
