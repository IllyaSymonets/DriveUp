package com.driveUp.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBillRequest {
    private long orderNumber;
    private CreateBill billInfo;
}
