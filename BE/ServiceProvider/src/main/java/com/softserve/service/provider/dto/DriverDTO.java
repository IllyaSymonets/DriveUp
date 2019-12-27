package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverDTO {
    private String city;
    private String licence;
    private int fine;
    private double rating;
}
