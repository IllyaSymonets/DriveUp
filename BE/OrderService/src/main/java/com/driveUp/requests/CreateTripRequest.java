package com.driveUp.requests;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTripRequest {

    private long orderNumber;
    private CreateTrip tripInfo;
}
