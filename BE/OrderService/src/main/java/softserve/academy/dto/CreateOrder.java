package softserve.academy.dto;

import lombok.Data;
import softserve.academy.domain.OrderType;

import java.util.Date;
import java.util.UUID;

@Data
public class CreateOrder {

    private long orderNumber;
    private OrderType orderType;
    private Date date;
    private long tripNumber;
    private UUID customerId;
    private UUID billId;

}
