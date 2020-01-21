package com.driveUp.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Builder
public class AddDriverRequest {
    private UUID customerId;

    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
