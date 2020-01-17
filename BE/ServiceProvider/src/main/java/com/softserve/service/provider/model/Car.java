package com.softserve.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @Column(nullable = false, length = 2)
    private Integer numberOfSeats;

    @Column(nullable = false)
    private boolean babyCarSeat;

    @Column(nullable = false)
    private boolean conditioner;

    @Column(nullable = false)
    private boolean pet;

    @Column(nullable = false)
    private boolean courier;

    @Column(nullable = false)
    private boolean english;

    @Column(nullable = false)
    private boolean nonSmoker;

    @Column(nullable = false)
    private boolean silence;
}
