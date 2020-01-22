package com.driveUp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ApprovedOrderDto extends CreatedOrderDto {

    private UUID driverId;
    private String driverPhone;
    private String brand;
    private String model;
    private String color;
    private String licencePlate;

    public ApprovedOrderDto(long orderNumber,
                            UUID orderId,
                            UUID customerId,
                            String customerPhone,
                            double price,
                            String wishTime,
                            String startAddress,
                            String finishAddress,
                            @JsonProperty("driver_id") UUID driverId,
                            @JsonProperty("driver_phone") String driverPhone,
                            @JsonProperty("brand") String brand,
                            @JsonProperty("model") String model,
                            @JsonProperty("color") String color,
                            @JsonProperty("licence_plate") String licencePlate) {
        super(orderNumber, orderId, customerId, customerPhone, price, wishTime, startAddress, finishAddress);
        this.driverId = driverId;
        this.driverPhone = driverPhone;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.licencePlate = licencePlate;
    }
}
