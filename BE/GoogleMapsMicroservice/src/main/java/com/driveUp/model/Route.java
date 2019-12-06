package com.driveUp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "route_id", nullable = false, updatable = false)
    private UUID route_id;

    @Positive
    @Column(name = "order_id", nullable = false, unique = true)
//    private UUID order_id;
    private long orderId;

    @NotEmpty
    @Column(columnDefinition = "varchar (255)",
            name = "start_address", nullable = false)
    private String startAddress;

    @NotEmpty
    @Column(columnDefinition = "varchar (255)",
            name = "destination_address", nullable = false)
    private String destinationAddress;

    @Positive
    @Column(name = "distance", nullable = false, updatable = false)
    private float distance;

    @Column(name = "departure_time", nullable = false, updatable = false)
    private String departureTime;

    @ElementCollection
    @Column(name = "start_coord")
    private List<Double> startCoord;

    @Column(columnDefinition = "varchar (255)", name = "start_type")
    private String startType;

    @Column(columnDefinition = "varchar (1000)", name = "startplace_id")
    private String startPlaceId;

    @ElementCollection
    @Column(name = "dest_coord")
    private List<Double> destCoord;

    @Column(columnDefinition = "varchar (255)", name = "dest_type")
    private String destType;

    @Column(columnDefinition = "varchar (1000)", name = "destplace_id")
    private String destPlaceId;

    @Column(columnDefinition = "text", name = "polyline", length = 4026)
    private String polyline;

    public Route(@Positive long orderId,
                 @NotEmpty String startAddress,
                 @NotEmpty String destinationAddress,
                 @Positive float distance,
                 List<Double> startCoord,
                 String startType,
                 String startPlaceId,
                 List<Double> destCoord,
                 String destType,
                 String destPlaceId,
                 String polyline,
                 String departureTime) {
        this.orderId = orderId;
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.distance = distance;
        this.startCoord = startCoord;
        this.startType = startType;
        this.startPlaceId = startPlaceId;
        this.destCoord = destCoord;
        this.destType = destType;
        this.destPlaceId = destPlaceId;
        this.polyline = polyline;
        this.departureTime = departureTime;
    }
}
