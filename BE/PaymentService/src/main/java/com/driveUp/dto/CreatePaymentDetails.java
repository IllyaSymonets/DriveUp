package softserve.academy.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreatePaymentDetails {

    private UUID driverId;
    private String card;
    private String cardName;
    private String cardFamilyName;

}
