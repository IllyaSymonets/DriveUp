package com.driveUp.service;

import com.driveUp.pojo.BillingDto;
import com.driveUp.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface MapsService {
    Route insertNewRout (String consumeJSONString, String departureTime);

    List<Route> getAllRouts();

    Optional<Route> getById(UUID uuid);

    BillingDto getDistance(long id);

}
