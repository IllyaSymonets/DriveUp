package com.driveUp.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTripRequest {

    private long orderNumber;
    private CreateTrip tripInfo;
}
