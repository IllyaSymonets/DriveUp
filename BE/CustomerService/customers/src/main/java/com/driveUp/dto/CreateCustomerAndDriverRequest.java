package com.driveUp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateCustomerAndDriverRequest {
    @NotNull
    private String phone;

    @NotNull
    private String password;

    @Email
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
