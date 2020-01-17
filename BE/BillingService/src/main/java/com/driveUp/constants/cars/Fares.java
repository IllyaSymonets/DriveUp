package com.driveUp.constants.cars;

import com.driveUp.constants.ConstantValues;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Fares {

    Map<String, BigDecimal> getAdditionalServices() {
        Map<String, BigDecimal> additionalServices = new HashMap<>();
        additionalServices.put(ConstantValues.CONDITIONER_FARE, BigDecimal.valueOf(15.0));
        additionalServices.put(ConstantValues.PETS_FARE,  BigDecimal.valueOf(20.0));
        additionalServices.put(ConstantValues.COURIER_FARE,  BigDecimal.valueOf(30.0));
        additionalServices.put(ConstantValues.ENGLISH_DRIVER,  BigDecimal.valueOf(10.0));
        additionalServices.put(ConstantValues.BABY_SEAT,  BigDecimal.valueOf(10.0));
        additionalServices.put(ConstantValues.NON_SMOKER,  BigDecimal.valueOf(10.0));
        additionalServices.put(ConstantValues.SILENCE,  BigDecimal.valueOf(10.0));
        return additionalServices;
    }

    public abstract Map<String, BigDecimal> getInfo();
}
