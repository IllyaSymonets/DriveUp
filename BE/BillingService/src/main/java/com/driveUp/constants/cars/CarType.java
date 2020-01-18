package com.driveUp.constants.cars;

import lombok.Getter;

import java.util.Map;

@Getter
public enum CarType {
    ECONOM(new EconomFares().getInfo(), "ECONOM"),
    BUSINESS(new BusinessFares().getInfo(), "BUSINESS"),
    VIP(new VIPFares().getInfo(), "VIP"),
    MINIVAN(new MinivanFares().getInfo(), "MINIVAN");

    Map<String, Double> info;
    String type;

    CarType(Map<String, Double> info, String type) {
        this.info = info;
        this.type = type;
    }
}