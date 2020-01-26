package com.driveUp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DriverDTO {
    @NotNull
    private UUID customerId;

    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
