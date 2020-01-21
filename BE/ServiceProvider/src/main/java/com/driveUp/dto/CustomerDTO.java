package com.driveUp.dto;

import lombok.Data;

@Data
class CustomerDTO {
    private String phone;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
}