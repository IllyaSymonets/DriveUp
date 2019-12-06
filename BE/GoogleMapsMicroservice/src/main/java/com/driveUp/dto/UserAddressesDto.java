package com.driveUp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressesDto {

    private String origins;
    private String destinations;
    private long orderId;
    private String depTime;

}
