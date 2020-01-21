package com.driveUp.requests;

import lombok.Data;

@Data
public class CreateTripRequest {

    private long orderNumber;
    private CreateTrip tripInfo;
}
