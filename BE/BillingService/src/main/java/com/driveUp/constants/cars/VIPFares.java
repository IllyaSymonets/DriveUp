package com.driveUp.constants.cars;

import com.driveUp.constants.ConstantValues;

import java.math.BigDecimal;
import java.util.Map;

public class VIPFares extends Fares {

    @Override
    public Map<String, BigDecimal> getInfo() {
        Map<String, BigDecimal> vipFares = getAdditionalServices();
        vipFares.put(ConstantValues.MINIMUM_TARIFF, BigDecimal.valueOf(90.0));
        vipFares.put(ConstantValues.TARIFF_PER_KM,  BigDecimal.valueOf(9.0));
        return vipFares;
    }
}