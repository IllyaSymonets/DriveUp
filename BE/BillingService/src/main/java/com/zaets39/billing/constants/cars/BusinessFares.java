package com.zaets39.billing.constants.cars;

import com.zaets39.billing.constants.ConstantValues;

import java.math.BigDecimal;
import java.util.Map;

public class BusinessFares extends Fares {

    @Override
    public Map<String, BigDecimal> getInfo() {
        Map<String, BigDecimal> businessFares = getAdditionalServices();
        businessFares.put(ConstantValues.MINIMUM_TARIFF,  BigDecimal.valueOf(55.0));
        businessFares.put(ConstantValues.TARIFF_PER_KM, BigDecimal.valueOf(7.5));
        return businessFares;
    }
}