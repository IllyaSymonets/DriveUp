package com.softserve.service.provider.listener;

import com.google.gson.Gson;
import com.softserve.service.provider.model.Driver;
import com.softserve.service.provider.repository.DriverRepository;
import com.softserve.service.provider.request.AddDriverRequest;
import com.softserve.service.provider.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Listener {
    private final Gson jsonConverter;
    private final DriverService driverService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final DriverRepository driverRepository;

    @KafkaListener(topics = "driver")
    public void getFromCustomer(String driverRequest) {
        @Valid AddDriverRequest addDriver = jsonConverter.fromJson(driverRequest, AddDriverRequest.class);
        driverService.add(addDriver);

        Driver driver = driverRepository.findDriverByLicence(addDriver.getLicence());
        UUID driverId = driver.getId();

        kafkaTemplate.send("billing", driverId.toString());
    }
}
