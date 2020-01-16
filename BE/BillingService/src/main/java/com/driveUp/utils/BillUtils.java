package com.driveUp.utils;

import com.driveUp.pojo.CreateBill;

import java.util.Map;

public class BillUtils {
    private BillUtils(){}
    public static double countPrice(CreateBill createBill) {
        Map<String, Double> additionalAmount = createBill.getCarType().getInfo();
        double amount = createBill.getDistance() * additionalAmount.get("TARIFF_PER_KM");
        if (createBill.isBabySeat())
            amount += additionalAmount.get("BABY_SEAT");
        if (createBill.isConditioner())
            amount += additionalAmount.get("CONDITIONER_FARE");
        if (createBill.isEnglishDriver())
            amount += additionalAmount.get("ENGLISH_DRIVER");
        if (createBill.isPet())
            amount += additionalAmount.get("PETS_FARE");
        if (createBill.isCourier())
            amount += additionalAmount.get("COURIER_FARE");
        if (createBill.isSilence())
            amount += additionalAmount.get("SILENCE");
        if (createBill.isNonSmoker())
            amount += additionalAmount.get("NON_SMOKER");
        return amount;
    }
}
