package com.zaets39.billing.constants;

import java.math.BigDecimal;

public class ConstantValues {
    private ConstantValues() {
    }

    public static final BigDecimal APPLICATION_PERCENT = BigDecimal.valueOf(0.12);
    public static final BigDecimal DRIVER_PERCENT = BigDecimal.valueOf(0.88);
    public static final String CARD_PAYMENT = "CARD";
    public static final String CASH_PAYMENT = "CASH";

    public static final String ECONOM_TYPE = "ECONOM";
    public static final String BUSINESS_TYPE = "BUSINESS";
    public static final String VIP_TYPE = "VIP";
    public static final String MINIVAN_TYPE = "MINIVAN";

    public static final String BABY_SEAT = "BABY_SEAT";
    public static final String CONDITIONER_FARE = "CONDITIONER_FARE";
    public static final String ENGLISH_DRIVER = "ENGLISH_DRIVER";
    public static final String PETS_FARE = "PETS_FARE";
    public static final String COURIER_FARE = "COURIER_FARE";
    public static final String SILENCE = "SILENCE";
    public static final String NON_SMOKER = "NON_SMOKER";

    public static final String TARIFF_PER_KM = "TARIFF_PER_KM";
    public static final String MINIMUM_TARIFF = "MINIMUM_TARIFF";
}
