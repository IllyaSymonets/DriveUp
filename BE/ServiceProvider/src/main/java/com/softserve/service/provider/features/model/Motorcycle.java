package com.softserve.service.provider.features.model;

import com.softserve.service.provider.model.Vehicle;
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
@SuperBuilder
@Entity
@Table(name = "motorcycles")
public class Motorcycle extends Vehicle {

    @Column(name = "motorcycle_type")
    private String type;
}
