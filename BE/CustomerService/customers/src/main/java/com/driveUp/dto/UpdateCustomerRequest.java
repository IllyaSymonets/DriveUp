package com.driveUp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class UpdateCustomerRequest {

    private UUID customerId;

    @Email
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

}
