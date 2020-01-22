package com.driveUp.service.generator;

import org.springframework.stereotype.Service;

@Service
public class CustomerNotificationsGenerator {

    public String getRegisteredOrderMess(long orderNumber) {
        return "You registered an order number " + orderNumber + ". Please, wait some minutes for answer.";
    }

    public String getConfirmedOrderMess(String driverPhone, double price, String wishTime) {
        return "Your order was taken by driver " + driverPhone + ". The cost of travel is " + price +
                "Your car will come at " + wishTime;
    }

    public String getCarArrived(String brand, String model, String color, String licencePlate) {
        return "The car " + brand + " " + model + " " + color + " " + licencePlate + " came to your address. " +
                "You can start your trip.";
    }
}
