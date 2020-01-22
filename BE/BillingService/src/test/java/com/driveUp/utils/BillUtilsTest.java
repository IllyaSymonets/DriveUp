package com.driveUp.utils;

import com.driveUp.constants.cars.CarType;
import com.driveUp.requests.ComfortFromUI;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class BillUtilsTest {

    @Test
    public void countPriceECONOMWithAdditionalParameters() {
        BigDecimal expected = BigDecimal.valueOf(202.50).setScale(2);
        BigDecimal actual = BillUtils.countPrice(new ComfortFromUI(true, true,
                true, true, true, true, true,
                CarType.ECONOM, 15));
        assertEquals(expected, actual);
    }
    @Test
    public void countPriceECONOMWithoutAdditionalParameters() {
        BigDecimal expected = BigDecimal.valueOf(143.00).setScale(2);
        BigDecimal actual = BillUtils.countPrice(new ComfortFromUI(false, false,
                false, false, false, false, false,
                CarType.ECONOM, 22));
        assertEquals(expected, actual);
    }
    @Test
    public void countPriceECONOMWithThreeAdditionalParameters() {
        BigDecimal expected = BigDecimal.valueOf(126.00).setScale(2);
        BigDecimal actual = BillUtils.countPrice(new ComfortFromUI(true, true,
                true, false, false, false, false,
                CarType.ECONOM, 14));
        assertEquals(expected, actual);
    }
    @Test
    public void countPriceECONOMWithFourAdditionalParameters() {
        BigDecimal expected = BigDecimal.valueOf(265.00).setScale(2);
        BigDecimal actual = BillUtils.countPrice(new ComfortFromUI(false, false,
                false, true, true, true, true,
                CarType.ECONOM, 30));
        assertEquals(expected, actual);
    }
//    @Test(expected = IllegalArgumentException.class)
//    public void countPriceECONOMNegativeDistance() {
//        BillUtils.countPrice(new ComfortFromUI(false, false,
//                false, false, false, false, false,
//                CarType.ECONOM), -22);
//    }
}
