package com.driveUp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCustomerDto {
    @NotNull
    private String phone;
    @NotNull
    private String password;
}
