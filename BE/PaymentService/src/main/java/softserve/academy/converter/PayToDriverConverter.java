package softserve.academy.converter;

import org.springframework.stereotype.Service;
import softserve.academy.dto.PayToDriver;
import softserve.academy.dto.RequestPayToDriver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayToDriverConverter {

    public PayToDriver convert(RequestPayToDriver driver) {
        PayToDriver payToDriver = new PayToDriver();
        payToDriver.setDriverId(driver.getDriverId());
        payToDriver.setSummary(BigDecimal.valueOf(driver.getSalary()).setScale(2));
        return payToDriver;
    }

    public List<PayToDriver> convertAll(List<RequestPayToDriver> drivers) {
        List<PayToDriver> convertedDrivers = new ArrayList<PayToDriver>();
        for (RequestPayToDriver driver : drivers) {
            convertedDrivers.add(convert(driver));
        }
        return convertedDrivers;
    }
}
