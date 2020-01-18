package com.driveUp.request;

import lombok.Data;

import java.util.UUID;

@Data
public class SetTripToOrderRequest {
    private long orderNumber;
    private UUID tripId;
}
