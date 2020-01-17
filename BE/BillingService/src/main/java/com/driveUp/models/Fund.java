package com.driveUp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private BigDecimal fundBalance;

    public Fund(@JsonProperty("driverId") UUID driverId,
                @JsonProperty("fundBalance") BigDecimal fundBalance) {
        this.driverId = driverId;
        this.fundBalance = fundBalance;
    }
}
