package com.zaets39.billing.constants.cars;

import com.zaets39.billing.constants.ConstantValues;

import java.math.BigDecimal;
import java.util.Map;

public class MinivanFares extends Fares {

    @Override
    public Map<String, BigDecimal> getInfo() {
        Map<String, BigDecimal> minivanFares = getAdditionalServices();
        minivanFares.put(ConstantValues.MINIMUM_TARIFF, BigDecimal.valueOf(90.0));
        minivanFares.put(ConstantValues.TARIFF_PER_KM, BigDecimal.valueOf(10.0));
        return minivanFares;
    }
}