package com.driveUp.requests;

import lombok.Data;

@Data
public class CreateTrip {

    private String origins;
    private String destinations;
    private String depTime;

}
