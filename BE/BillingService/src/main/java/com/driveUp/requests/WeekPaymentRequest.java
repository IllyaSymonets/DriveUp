package com.driveUp.requests;

import lombok.*;

import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@AllArgsConstructor
public class WeekPaymentRequest {
    private UUID driverId;
    @Positive
    private double salary;
}