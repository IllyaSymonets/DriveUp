package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@AllArgsConstructor
public class SetBillToOrderRequest {
    @Positive
    private long orderNumber;
    private UUID billId;
}