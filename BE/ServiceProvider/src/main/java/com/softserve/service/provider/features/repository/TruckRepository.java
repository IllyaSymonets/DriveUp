package com.softserve.service.provider.features.repository;

import com.softserve.service.provider.features.model.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TruckRepository extends CrudRepository<Truck, UUID> {
}
