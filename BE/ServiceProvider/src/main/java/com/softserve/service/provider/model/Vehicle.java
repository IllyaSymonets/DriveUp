package com.softserve.service.provider.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
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

    @Size(min = 4, max = 10)
    @Column(nullable = false, unique = true, length = 10)
    private String licencePlate;

    @Size(min = 4, max = 24)
    @Column(nullable = false, length = 25)
    private String colour;

    @Size(min = 4, max = 24)
    @Column(nullable = false, length = 25)
    private String brand;

    @Size(min = 4, max = 24)
    @Column(nullable = false, length = 25)
    private String model;

    @Positive
    @Column(nullable = false, length = 4)
    private Integer yearOfProduction;

}
