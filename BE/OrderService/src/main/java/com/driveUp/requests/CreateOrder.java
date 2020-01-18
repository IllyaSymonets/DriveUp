package com.driveUp.requests;

import lombok.Data;
import com.driveUp.domain.OrderType;

import java.util.Date;

@Data
public class CreateOrder {

    private OrderType orderType;
    private Date date;
    private CreateTrip tripInfo;
    private CreateBill billInfo;

}
