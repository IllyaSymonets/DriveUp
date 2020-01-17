package com.zaets39.billing.requests;

import com.zaets39.billing.constants.cars.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class ComfortFromUI {
    private boolean babySeat;
    private boolean englishDriver;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean nonSmoker;
    private boolean silence;
    private CarType carType;
}
