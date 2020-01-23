package com.driveUp.repositories;

import com.driveUp.models.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FundRepository extends JpaRepository<Fund, Long> {
    List<Fund> findAll();

    Fund findByDriverId(UUID DriverId);
}
