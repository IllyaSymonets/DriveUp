package com.softserve.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    @Column(name = "car_type")
    private String type;

    @Positive
    @Column(nullable = false, length = 2)
    private Integer numberOfSeats;

    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
