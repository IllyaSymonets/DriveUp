package com.driveUp.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SalaryPaid {
    private UUID driverId;
    private boolean transactionResult;
}
