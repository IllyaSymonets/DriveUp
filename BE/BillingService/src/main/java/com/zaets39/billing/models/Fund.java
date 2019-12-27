package com.zaets39.billing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private double fundBalance;

    public Fund(@JsonProperty("driverId") UUID driverId,
                @JsonProperty("fundBalance") double fundBalance) {
        this.driverId = driverId;
        this.fundBalance = fundBalance;
    }
}
