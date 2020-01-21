package com.driveUp.requests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillRequest {
    private long orderNumber;
    private CreateBill billInfo;
}
