package com.zaets39.billing.constants.cars;

import java.util.Map;

public class EconomFares extends Fares {

    @Override
    public Map<String, Double> getInfo() {
        Map<String, Double> economFares = getAdditionalServices();
        economFares.put("MINIMUM_TARIFF", 33.0);
        economFares.put("TARIFF_PER_KM", 6.5);
        return economFares;
    }
}