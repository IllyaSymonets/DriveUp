package com.driveUp.converter;

import com.driveUp.domain.Order;
import com.driveUp.request.OrderDetailsToView;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter {

    public OrderDetailsToView toOrderDetailsToView(Order order) {
        OrderDetailsToView orderDetails = new OrderDetailsToView(
                order.getOrderNumber(), order.getDate());
        return orderDetails;
    }
}
