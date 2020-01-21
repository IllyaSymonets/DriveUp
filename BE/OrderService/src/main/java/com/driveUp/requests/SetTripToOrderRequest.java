package com.driveUp.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class SetTripToOrderRequest {
    private long orderNumber;
    private UUID tripId;
}
