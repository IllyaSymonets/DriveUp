package com.driveUp.listener;

import com.driveUp.model.Driver;
import com.google.gson.Gson;
import com.driveUp.repository.DriverRepository;
import com.driveUp.request.AddDriverRequest;
import com.driveUp.service.DriverService;
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
    public void getRequestFromCustomerMS(String driverRequest) {
        @Valid AddDriverRequest addDriver = jsonConverter.fromJson(
                driverRequest, AddDriverRequest.class);

        driverService.add(addDriver);

        Driver driver = driverRepository.findDriverByLicence(addDriver.getLicence());
        UUID driverId = driver.getId();

        kafkaTemplate.send("billing", driverId.toString());
    }
}
