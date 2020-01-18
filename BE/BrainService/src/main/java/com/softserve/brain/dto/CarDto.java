package com.softserve.brain.dto;

import lombok.Data;

@Data
public class CarDto {
    private String type;
    private String licencePlate;
    private String colour;
    private String brand;
    private String model;
    private int yearOfProduction;
    private int numberOfSeats;
    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
