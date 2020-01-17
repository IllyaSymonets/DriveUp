package com.softserve.service.provider.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
abstract class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String licencePlate;

    @Column(nullable = false, length = 25)
    private String colour;

    @Column(nullable = false, length = 25)
    private String brand;

    @Column(nullable = false, length = 25)
    private String model;

    @Column(nullable = false, length = 4)
    private Integer yearOfProduction;

}
