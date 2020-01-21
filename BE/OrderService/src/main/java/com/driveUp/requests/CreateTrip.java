package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTrip {

    private String origins;
    private String destinations;
    private String depTime;
}
