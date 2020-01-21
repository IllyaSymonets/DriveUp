package com.driveUp.repository;

import com.driveUp.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {
}
