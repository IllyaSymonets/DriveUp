package com.driveUp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDriverView {

    private BillingDetailsToView billingDetailsToView;
    private CustomerDetailsToView customerDetailsToView;
    private OrderDetailsToView orderDetailsToView;
    private TripDetailsToView tripDetailsToView;

}
