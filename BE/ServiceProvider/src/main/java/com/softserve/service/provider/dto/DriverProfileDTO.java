package com.softserve.service.provider.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DriverProfileDTO {
    private CarDTO car;
    private List<HistoryDTO> histories;
    private DriverDTO driverDTO;
}
