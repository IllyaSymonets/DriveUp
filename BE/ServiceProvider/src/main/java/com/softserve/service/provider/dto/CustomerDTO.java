package com.softserve.service.provider.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String phone;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
}