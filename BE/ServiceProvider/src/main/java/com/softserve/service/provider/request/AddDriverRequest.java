package com.softserve.service.provider.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@Builder
public class AddDriverRequest {
    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
