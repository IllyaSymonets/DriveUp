package com.driveUp.request;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class DriverFineRequest {
    @PositiveOrZero
    private Integer fine;
}
