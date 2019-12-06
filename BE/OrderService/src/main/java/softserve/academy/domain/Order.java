package softserve.academy.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="orders")
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

    @Column(name = "trip_number", updatable = false, nullable = false)
    private long tripNumber;

    @Column(name = "customer_id", updatable = false, nullable = false)
    private UUID customerId;

    @Column(name = "driver_id", updatable = false, nullable = false)
    private UUID driverId;

    @Column(name = "bill_id", updatable = false, nullable = false)
    private UUID billId;

    @Column(name = "bill_id", nullable = false)
    private OrderStatus status = OrderStatus.CREATED;
}
