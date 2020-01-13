package com.driveUp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "order_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "order_number", updatable = false, nullable = false)
    private long orderNumber;

    @Column(name = "order_type", updatable = false, nullable = false)
    private OrderType orderType;

    @Column(name = "order_date_time", updatable = false, nullable = false)
    private Date date;

    @Column(name = "trip_number", updatable = false, nullable = false)
    private long tripNumber;

    @Column(name = "customer_id", updatable = false, nullable = false)
    private UUID customerId;

    @Column(name = "driver_id")
    private UUID driverId;

    @Column(name = "bill_id", updatable = false, nullable = false)
    private UUID billId;

    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;

}
