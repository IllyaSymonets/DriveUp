package com.driveUp.requests;

import com.driveUp.constants.cars.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @NotNull
    private CarType carType;
    @Positive
    @Min(1)
    private double distance;
}
