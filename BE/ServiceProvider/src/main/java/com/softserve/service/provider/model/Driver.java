package com.softserve.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
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

    @CreationTimestamp
    private Date dateOfRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Car car;

    @Size(max = 50)
    @Column(nullable = false)
    private String city;

    @Size(min = 4, max = 24)
    @Column(nullable = false)
    private String firstName;

    @Size(min = 4, max = 24)
    @Column(nullable = false)
    private String lastName;

    @Size(min = 4, max = 10)
    @Column(unique = true, length = 24)
    private String licence;

    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 10, max = 10)
    @Column(nullable = false, unique = true)
    private String phone;

    @Size(min = 8, max = 24)
    @Column(nullable = false, length = 24)
    private String password;

    @PositiveOrZero
    @Column(columnDefinition = "integer default 0")
    private int fine;

    @PositiveOrZero
    @Column(columnDefinition = "double precision default 0")
    private double rating;
}
