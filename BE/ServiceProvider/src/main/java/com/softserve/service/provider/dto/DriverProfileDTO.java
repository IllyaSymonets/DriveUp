package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DriverProfileDTO {
    private CarDTO car;
    private List<HistoryDTO> histories;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String licence;
    private int fine;
    private double rating;
}
