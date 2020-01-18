package com.driveUp.utils;
import com.driveUp.constants.ConstantValues;
import com.driveUp.requests.ComfortFromUI;

import java.math.BigDecimal;
import java.util.Map;

public class BillUtils {
    private BillUtils() {
    }

    public static BigDecimal countPrice(ComfortFromUI comfortFromUI, double dist) {
        Map<String, BigDecimal> additionalAmount = comfortFromUI.getCarType().getInfo();
        BigDecimal distance = BigDecimal.valueOf(dist);
        BigDecimal amount = distance.multiply(additionalAmount.get(ConstantValues.TARIFF_PER_KM));
        if (comfortFromUI.isBabySeat())
            amount = amount.add(additionalAmount.get(ConstantValues.BABY_SEAT));
        if (comfortFromUI.isConditioner())
            amount = amount.add(additionalAmount.get(ConstantValues.CONDITIONER_FARE));
        if (comfortFromUI.isEnglishDriver())
            amount = amount.add(additionalAmount.get(ConstantValues.ENGLISH_DRIVER));
        if (comfortFromUI.isPet())
           amount =  amount.add(additionalAmount.get(ConstantValues.PETS_FARE));
        if (comfortFromUI.isCourier())
            amount = amount.add(additionalAmount.get(ConstantValues.COURIER_FARE));
        if (comfortFromUI.isSilence())
            amount = amount.add(additionalAmount.get(ConstantValues.SILENCE));
        if (comfortFromUI.isNonSmoker())
           amount =  amount.add(additionalAmount.get(ConstantValues.NON_SMOKER));
        return amount;
    }
}
