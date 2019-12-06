package com.zaets39.billing.constants.cars;

import java.util.HashMap;
import java.util.Map;

public abstract class Fares {

    public Map<String, Double> getAdditionalServices() {
        Map<String, Double> additionalServices = new HashMap<String, Double>();
        additionalServices.put("CONDITIONER_FARE", 15.0);
        additionalServices.put("PETS_FARE", 20.0);
        additionalServices.put("COURIER_FARE", 30.0);
        additionalServices.put("ENGLISH_DRIVER", 10.0);
        additionalServices.put("BABY_SEAT", 10.0);
        additionalServices.put("NON_SMOKER", 10.0);
        additionalServices.put("SILENCE", 10.0);
        return additionalServices;
    }

    public abstract Map<String, Double> getInfo();
}
