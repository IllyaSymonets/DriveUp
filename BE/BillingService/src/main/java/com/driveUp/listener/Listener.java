package com.driveUp.listener;

import com.driveUp.services.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Listener {
    private final FundService fundService;

    @KafkaListener(topics = "billing")
    public void getDriverUUID (String driverUUID) {
        UUID uuid = UUID.fromString(driverUUID);
        fundService.addFund(uuid);
    }
}
