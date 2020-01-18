package com.driveUp.constants.cars;

import lombok.Getter;

@Getter
public enum CarType {
    ECONOM("ECONOM"),
    BUSINESS("BUSINESS"),
    VIP("VIP"),
    MINIVAN("MINIVAN");

    String type;

    CarType(String type) {
        this.type = type;
    }
}