package com.driveUp.requests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillRequest {
    @Positive
    private long orderNumber;
    private CreateBill billInfo;
}
