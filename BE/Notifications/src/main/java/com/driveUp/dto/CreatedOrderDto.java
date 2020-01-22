package com.driveUp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class CreatedOrderDto {

    private long orderNumber;
    private UUID orderId;
    private UUID customerId;
    private String customerPhone;
    private double price;
    private String wishTime;
    private String startAddress;
    private String finishAddress;

    CreatedOrderDto(
            @JsonProperty("order_number") long orderNumber,
            @JsonProperty("order_id") UUID orderId,
            @JsonProperty("customer_id") UUID customerId,
            @JsonProperty("customer_phone") String customerPhone,
            @JsonProperty("price") double price,
            @JsonProperty("wish_time") String wishTime,
            @JsonProperty("start_address") String startAddress,
            @JsonProperty("finish_address") String finishAddress) {
        this.orderNumber = orderNumber;
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerPhone = customerPhone;
        this.price = price;
        this.wishTime = wishTime;
        this.startAddress = startAddress;
        this.finishAddress = finishAddress;
    }
}
