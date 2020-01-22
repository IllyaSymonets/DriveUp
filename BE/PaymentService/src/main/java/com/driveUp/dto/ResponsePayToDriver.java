package com.driveUp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ResponsePayToDriver {
    UUID driverId;
    boolean isSuccess;
}
