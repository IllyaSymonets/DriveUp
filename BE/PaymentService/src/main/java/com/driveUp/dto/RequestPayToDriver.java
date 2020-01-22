package softserve.academy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RequestPayToDriver {
    UUID driverId;
    double salary;
}
