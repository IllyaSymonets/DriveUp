package com.zaets39.billing.constants.cars;

import java.util.Map;

public class BusinessFares extends Fares {

    @Override
    public Map<String, Double> getInfo() {
        Map<String, Double> businessFares = getAdditionalServices();
        businessFares.put("MINIMUM_TARIFF", 55.0);
        businessFares.put("TARIFF_PER_KM", 7.5);
        return businessFares;
    }
}