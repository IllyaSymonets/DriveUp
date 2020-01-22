package com.driveUp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class CreatedOrderDtoWithDrivers extends CreatedOrderDto {

    private List<DriverInfo> listOfDrivers;

    public CreatedOrderDtoWithDrivers(long orderNumber,
                                      UUID orderId,
                                      UUID customerId,
                                      String customerPhone,
                                      double price,
                                      String wishTime,
                                      String startAddress,
                                      String finishAddress,
                                      @JsonProperty("list_of_drivers") List<DriverInfo> listOfDrivers) {
        super(orderNumber, orderId, customerId, customerPhone, price, wishTime, startAddress,
                finishAddress);
        this.listOfDrivers = listOfDrivers;
    }
}
