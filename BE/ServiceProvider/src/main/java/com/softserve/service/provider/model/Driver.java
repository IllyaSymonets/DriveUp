package com.softserve.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue
    @Column(name = "driver_id")
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @CreationTimestamp
    private Date dateOfRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Car car;

    @Column(nullable = false)
    private String city;

    @Column(unique = true, length = 24)
    private String licence;

    @Column(columnDefinition = "integer default 0")
    private int fine;

    @Column(columnDefinition = "double precision default 0")
    private double rating;
}
