package com.driveUp.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class FundRequest {
    private UUID driverId = UUID.randomUUID();
}
