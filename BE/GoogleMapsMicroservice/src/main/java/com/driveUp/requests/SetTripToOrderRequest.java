package com.driveUp.requests;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SetTripToOrderRequest {
    private long orderNumber;
    private UUID tripId;
}

