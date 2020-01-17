package softserve.academy.request;

import lombok.Data;

@Data
public class TripDetailsToView {
    private String startAddress;
    private String destinationAddress;
}
