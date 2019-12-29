package com.zaets39.billing.utils;

import com.zaets39.billing.requests.BillRequest;

import java.util.Map;

public class BillUtils {
    private BillUtils() {
    }

    public static double countPrice(BillRequest billRequest) {
        Map<String, Double> additionalAmount = billRequest.getCarType().getInfo();
        double amount = billRequest.getDistance() * additionalAmount.get("TARIFF_PER_KM");
        if (billRequest.isBabySeat())
            amount += additionalAmount.get("BABY_SEAT");
        if (billRequest.isConditioner())
            amount += additionalAmount.get("CONDITIONER_FARE");
        if (billRequest.isEnglishDriver())
            amount += additionalAmount.get("ENGLISH_DRIVER");
        if (billRequest.isPet())
            amount += additionalAmount.get("PETS_FARE");
        if (billRequest.isCourier())
            amount += additionalAmount.get("COURIER_FARE");
        if (billRequest.isSilence())
            amount += additionalAmount.get("SILENCE");
        if (billRequest.isNonSmoker())
            amount += additionalAmount.get("NON_SMOKER");
        return amount;
    }
}
