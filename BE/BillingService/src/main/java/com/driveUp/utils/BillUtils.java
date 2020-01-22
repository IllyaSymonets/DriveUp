package com.driveUp.utils;
import com.driveUp.constants.ConstantValues;
import com.driveUp.requests.ComfortFromUI;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BillUtils {
    private BillUtils() {
    }

    public static BigDecimal countPrice(ComfortFromUI comfortFromUI, double dist) {
        Map<String, BigDecimal> additionalAmount = comfortFromUI.getCarType().getInfo();
        BigDecimal distance = BigDecimal.valueOf(dist);
        BigDecimal amount = distance.multiply(additionalAmount.get(ConstantValues.TARIFF_PER_KM));
        Map<String, Boolean> currentComfort = getMapWithCurrentComfort(comfortFromUI);
        for (Map.Entry<String, Boolean> entry : currentComfort.entrySet()){
            if(entry.getValue().equals(true)){
                amount = amount.add(additionalAmount.get(entry.getKey()));
            }
        }
        return amount;
    }

    private static Map<String, Boolean> getMapWithCurrentComfort(ComfortFromUI comfortFromUI)
    {
        Map<String,Boolean> currentComfort = new HashMap<>();
        currentComfort.put(ConstantValues.BABY_SEAT, comfortFromUI.isBabySeat());
        currentComfort.put(ConstantValues.CONDITIONER_FARE, comfortFromUI.isConditioner());
        currentComfort.put(ConstantValues.ENGLISH_DRIVER, comfortFromUI.isEnglishDriver());
        currentComfort.put(ConstantValues.PETS_FARE, comfortFromUI.isPet());
        currentComfort.put(ConstantValues.COURIER_FARE, comfortFromUI.isCourier());
        currentComfort.put(ConstantValues.SILENCE, comfortFromUI.isSilence());
        currentComfort.put(ConstantValues.NON_SMOKER, comfortFromUI.isNonSmoker());
        return currentComfort;
    }
}
