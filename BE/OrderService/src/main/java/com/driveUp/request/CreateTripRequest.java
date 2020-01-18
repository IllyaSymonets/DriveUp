package com.driveUp.request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTripRequest {

    private long orderNumber;
    private CreateTrip tripInfo;
}
