package com.softserve.service.provider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
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

    private UUID driverId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    @CreationTimestamp
    private Date date;

    @Column(name = "start")
    private String startPoint;

    @Column(name = "finish")
    private String finishPoint;

    @Positive
    private Double distance;

    @Positive
    private Double travelTime;

    @Positive
    private Double price;

    @PositiveOrZero
    @Max(value = 5)
    private Double rating;

    @PositiveOrZero
    private Integer fine;

    @Size(max = 140)
    private String description;
}
