package com.softserve.brain.dto;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class DriverDto {
    private String clientId;
    private String firstName;
    private String secondName;
    private String email;
    private String city;
    private String driverLicense;
    private double rating;
    private int fine;
    private CarDto car;

}
