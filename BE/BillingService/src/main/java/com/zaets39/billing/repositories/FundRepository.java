package com.zaets39.billing.repositories;

import com.zaets39.billing.models.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FundRepository extends JpaRepository<Fund, Long> {
    @Override
    List<Fund> findAll();

    Fund findByDriverId(UUID DriverId);
}
