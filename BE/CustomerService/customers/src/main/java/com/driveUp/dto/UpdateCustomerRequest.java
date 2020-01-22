package com.driveUp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateCustomerRequest {

    private UUID customerId;
    private String email;
    private String firstName;
    private String secondName;

}
