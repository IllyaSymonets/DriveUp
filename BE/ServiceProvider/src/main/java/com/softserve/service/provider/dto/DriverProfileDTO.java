package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DriverProfileDTO {
    private CustomerDTO customerDTO;
    private DriverDTO driverDTO;
    private CarDTO car;
    private List<HistoryDTO> histories;
}
