package com.softserve.service.provider.repository;

import com.softserve.service.provider.model.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {

}
