package com.softserve.service.provider.futureFeaturesNotToUse;

import com.softserve.service.provider.model.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    @Column(name = "truck_type")
    private String type;

    @Range(min = 500, max = 10000)
    @Column(name = "truck_capacity", nullable = false)
    private Integer carryingCapacity;

}
