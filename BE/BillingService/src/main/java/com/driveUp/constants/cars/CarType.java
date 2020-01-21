package com.driveUp.constants.cars;

import com.driveUp.constants.ConstantValues;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
public enum CarType {
    ECONOM(new EconomFares().getInfo(), ConstantValues.ECONOM_TYPE),
    BUSINESS(new BusinessFares().getInfo(), ConstantValues.BUSINESS_TYPE),
    VIP(new VIPFares().getInfo(), ConstantValues.VIP_TYPE),
    MINIVAN(new MinivanFares().getInfo(), ConstantValues.MINIVAN_TYPE);

    Map<String, BigDecimal> info;
    String type;

    CarType(Map<String, BigDecimal> info, String type) {
        this.info = info;
        this.type = type;
    }
}