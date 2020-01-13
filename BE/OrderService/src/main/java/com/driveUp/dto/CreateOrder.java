package com.driveUp.dto;

import lombok.Data;
import com.driveUp.domain.OrderType;

import java.util.Date;

@Data
public class CreateOrder {

    private long orderNumber;
    private OrderType orderType;
    private Date date;
    private CreateTrip tripInfo;

}
