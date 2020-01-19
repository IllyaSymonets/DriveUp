package customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DriverDTO {
    private UUID customerId;

    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
