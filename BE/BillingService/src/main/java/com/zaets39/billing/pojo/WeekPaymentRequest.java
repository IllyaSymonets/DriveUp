package com.zaets39.billing.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class WeekPaymentRequest {
    private UUID driverId;
    private double salary;

    public WeekPaymentRequest(UUID driverId, double salary) {
        this.driverId = driverId;
        this.salary = salary;
    }
}
