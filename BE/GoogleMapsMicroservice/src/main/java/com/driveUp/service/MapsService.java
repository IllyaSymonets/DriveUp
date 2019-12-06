package com.driveUp.service;

import com.driveUp.dto.BillingDto;
import com.driveUp.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface MapsService {

    void insertNewRout (String consumeJSONString, long orderId, String departureTime);

    List<Route> getAllRouts();

    Optional<Route> getById(UUID uuid);

    BillingDto getDistance(long id);



}
