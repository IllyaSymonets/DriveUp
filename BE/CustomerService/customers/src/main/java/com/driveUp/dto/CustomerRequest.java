package com.driveUp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class CustomerRequest {
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
}