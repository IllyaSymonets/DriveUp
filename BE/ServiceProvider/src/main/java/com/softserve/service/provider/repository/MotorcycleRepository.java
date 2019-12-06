package com.softserve.service.provider.repository;

import com.softserve.service.provider.model.Motorcycle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MotorcycleRepository extends CrudRepository<Motorcycle, UUID> {
}
