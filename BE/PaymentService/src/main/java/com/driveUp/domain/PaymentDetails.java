package softserve.academy.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "payment_details")
@ToString
public class PaymentDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "payment_details_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "driver_id", updatable = false, nullable = false)
    private UUID driverId;

    @CreditCardNumber
    @Column(name = "driver_card", nullable = false, length = 16)
    private String card;

    @Column(name = "driver_card_name", nullable = false, length = 50)
    private String cardName;

    @Column(name = "driver_card_family_name", nullable = false, length = 50)
    private String cardFamilyName;

    @Column(name = "driver_card_is_actual", nullable = false)
    private boolean isActual = true;

    public PaymentDetails(UUID driverId, @CreditCardNumber String card,
                          String cardName, String cardFamilyName) {

        this.driverId = driverId;
        this.card = card;
        this.cardName = cardName;
        this.cardFamilyName = cardFamilyName;
    }

    public PaymentDetails() {
    }
}
