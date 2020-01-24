package com.driveUp.service;

import com.driveUp.dto.ChangePasswordDto;
import com.driveUp.dto.CreateCustomerDto;
import com.driveUp.model.Customer;

import java.util.UUID;

public interface CustomerService {

    Customer saveCustomer(CreateCustomerDto customerDto);

    Customer updatePassword(ChangePasswordDto changePasswordDto);

    Customer updateCustomer(UUID customerId, String email, String firstName,
                            String secondName);

    Customer getCustomerById(UUID customerId);

    String getEmailById(UUID customerId);

    String getPhoneById(UUID customerId);

    Iterable<Customer> getAllCustomers();
}
