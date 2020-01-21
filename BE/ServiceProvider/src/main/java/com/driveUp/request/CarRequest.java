package com.driveUp.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
public class CarRequest {
    private String type;

    @Size(min = 4, max = 10)
    private String licencePlate;

    @Size(min = 4, max = 24)
    private String colour;

    @Size(min = 4, max = 24)
    private String brand;

    @Size(min = 4, max = 24)
    private String model;

    @Positive
    private Integer yearOfProduction;

    @Positive
    @Max(12)
    private Integer numberOfSeats;

    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
