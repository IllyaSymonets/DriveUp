package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetBillToOrderRequest {
    private long orderNumber;
    private UUID billId;
}