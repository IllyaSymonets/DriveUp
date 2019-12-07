package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverDTO {
    private String city;
    private String firstName;
    private String lastName;
    private String licence;
    private String email;
    private String phone;
    private String password;
    private int fine;
    private double rating;
}
