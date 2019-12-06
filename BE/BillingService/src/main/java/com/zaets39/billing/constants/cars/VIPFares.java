package com.zaets39.billing.constants.cars;

import java.util.Map;

public class VIPFares extends Fares {

    @Override
    public Map<String, Double> getInfo() {
        Map<String, Double> vipFares = getAdditionalServices();
        vipFares.put("MINIMUM_TARIFF", 90.0);
        vipFares.put("TARIFF_PER_KM", 9.0);
        return vipFares;
    }
}