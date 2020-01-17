package com.driveUp.requests;

import com.driveUp.constants.cars.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;

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
