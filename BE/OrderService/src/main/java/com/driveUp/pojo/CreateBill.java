package com.driveUp.pojo;

import com.driveUp.constants.cars.CarType;
import lombok.Data;

@Data
public class CreateBill {
    private boolean babySeat;
    private boolean englishDriver;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean nonSmoker;
    private boolean silence;
    private CarType carType;
    private double distance;
    private String paymentMode;
}
