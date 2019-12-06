package com.zaets39.billing.constants.cars;

import java.util.Map;

public class MinivanFares extends Fares {

    @Override
    public Map<String, Double> getInfo() {
        Map<String, Double> minivanFares = getAdditionalServices();
        minivanFares.put("MINIMUM_TARIFF", 90.0);
        minivanFares.put("TARIFF_PER_KM", 10.0);
        return minivanFares;
    }
}
