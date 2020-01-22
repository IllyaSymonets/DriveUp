package softserve.academy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "transaction_date_time", updatable = false, nullable = false)
    private Date date;

    @Column(name = "transaction_from_who_id", updatable = false, nullable = false)
    private UUID fromWhoId;

    @Column(name = "transaction_to_who_id", updatable = false, nullable = false)
    private UUID toWhoId;

    @Column(name = "transaction_summary", updatable = false, nullable = false)
    private BigDecimal summary;

    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus status = TransactionStatus.inProgress;

    public Transaction(Date date, UUID fromWhoId, UUID toWhoId, BigDecimal summary) {
        this.date = date;
        this.fromWhoId = fromWhoId;
        this.toWhoId = toWhoId;
        this.summary = summary;
    }


}
