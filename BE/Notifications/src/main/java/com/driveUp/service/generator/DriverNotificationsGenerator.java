package notifications.service.generator;

import org.springframework.stereotype.Service;

@Service
public class DriverNotificationsGenerator {

    public String getRegisteredOrderMess(String customerPhone, String wishRime, String startAddress,
                                         String finishAddress) {
        return "New order: passenger " + customerPhone + "is waiting  at " + wishRime + " on " + startAddress +
                "to get to " + finishAddress + ". Needs to confirm.";
    }

    public String getConfirmedOrderMess(long orderNumber, String customerPhone, String wishTime,
                                        String startAddress) {
        return "You confirmed the order " + orderNumber + ". Passenger " + customerPhone + " will wait you at "
                + wishTime + " on " + startAddress;
    }
}
