package com.driveUp.repository;

import com.driveUp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {

    @Query(value = "SELECT distance FROM routes WHERE order_id = ?1", nativeQuery = true)
    float getDistance(long id);

}
