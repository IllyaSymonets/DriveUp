package com.driveUp.repository;

import com.driveUp.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    Customer getCustomerByPhone(String phone);
}
