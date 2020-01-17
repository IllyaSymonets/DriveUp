package com.driveUp.constants.cars;

import com.driveUp.constants.ConstantValues;

import java.math.BigDecimal;
import java.util.Map;

public class EconomFares extends Fares {

    @Override
    public Map<String, BigDecimal> getInfo() {
        Map<String, BigDecimal> economFares = getAdditionalServices();
        economFares.put(ConstantValues.MINIMUM_TARIFF,  BigDecimal.valueOf(33.0));
        economFares.put(ConstantValues.TARIFF_PER_KM, BigDecimal.valueOf(6.5));
        return economFares;
    }
}