package com.driveUp.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTripRequest {

    private UUID orderId;
    private CreateTrip tripInfo;
}
