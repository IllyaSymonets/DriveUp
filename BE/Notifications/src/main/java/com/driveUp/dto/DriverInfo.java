package com.driveUp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class DriverInfo {

    private UUID driverId;
    private String driverPhone;

    public DriverInfo(@JsonProperty("driver_id") UUID driverId,
                      @JsonProperty("driver_phone") String driverPhone) {
        this.driverId = driverId;
        this.driverPhone = driverPhone;
    }
}
