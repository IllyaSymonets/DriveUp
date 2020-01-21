package com.driveUp.model;

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
@Table(name = "histories")
public class History {

    @Id
    @GeneratedValue
    @Column(name = "history_id")
    private UUID id;

    @JoinColumn(name = "driver_id")
    private UUID driverId;

    @CreationTimestamp
    private Date dateOfTrip;

    @Column(nullable = false, name = "start")
    private String startPoint;

    @Column(nullable = false, name = "finish")
    private String finishPoint;

    @Column(length = 140)
    private String description;

    @Column(nullable = false)
    private Double distance;

    @Column(nullable = false)
    private Double travelTime;

    @Column(nullable = false)
    private Double price;

    private Double rating;

    private Integer fine;

}
