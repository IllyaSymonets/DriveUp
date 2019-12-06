package notifications.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "phone_notifications")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PhoneNotification {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "notification_id", nullable = false)
    private UUID notificationId;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "date_and_time", nullable = false, length = 25)
    private String dateAndTime;

    @Column(name = "message", nullable = false, length = 300)
    private String message;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    public PhoneNotification(UUID customerId, String dateAndTime, String message, String phone,
                             UUID orderId) {
        this.customerId = customerId;
        this.dateAndTime = dateAndTime;
        this.message = message;
        this.phone = phone;
        this.orderId = orderId;
    }
}
