package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    private String type;
    private String licencePlate;
    private String colour;
    private String brand;
    private String model;
    private Integer yearOfProduction;
    private Integer numberOfSeats;
    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
