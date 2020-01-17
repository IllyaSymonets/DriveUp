package com.softserve.service.provider.request;

import lombok.Data;

@Data
public class SearchCarRequest {
    private String type;
    private boolean babyCarSeat;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean english;
    private boolean nonSmoker;
    private boolean silence;
}
