package com.driveUp.request;

import lombok.Data;

@Data
public class CreateTrip {

    private String origins;
    private String destinations;
    private String depTime;
}
