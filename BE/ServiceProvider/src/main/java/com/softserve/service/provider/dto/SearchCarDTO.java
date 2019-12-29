package com.softserve.service.provider.dto;

import lombok.Data;

@Data
public class SearchCarDTO {
    private String type;
    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
