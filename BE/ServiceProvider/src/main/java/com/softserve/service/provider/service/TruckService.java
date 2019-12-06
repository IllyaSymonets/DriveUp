package com.softserve.service.provider.service;

import com.softserve.service.provider.consts.Constants;
import com.softserve.service.provider.model.Truck;
import com.softserve.service.provider.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TruckService {
    private final TruckRepository truckRepository;

    public Truck addTruck(Truck truck) {
        truck.setType(calculateType(truck));
        return truckRepository.save(truck);
    }

    public Iterable<Truck> getAll() {
        return truckRepository.findAll();
    }

    public void delTruck(UUID id) {
        truckRepository.deleteById(id);
    }

    private String calculateType(Truck truck) {
        String type = "n/a";

        if (truck.getCarryingCapacity() <= 2000) {
            type = Constants.LIGHT;
        }

        if (truck.getCarryingCapacity() > 2000 && truck.getCarryingCapacity() <= 5000) {
            type = Constants.MEDIUM;
        }

        if (truck.getCarryingCapacity() > 5000) {
            type = Constants.HEAVY;
        }

        return type;
    }
}
