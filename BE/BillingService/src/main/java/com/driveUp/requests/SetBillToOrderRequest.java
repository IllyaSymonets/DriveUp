package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SetBillToOrderRequest {
    private long orderNumber;
    private UUID billId;
}