package com.driveUp.requests;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public class WeekPaymentRequest {
    private UUID driverId;
    private double salary;
}
