package com.driveUp.controller;

import com.driveUp.converter.OrderConverter;
import com.driveUp.domain.Order;
import com.driveUp.request.OrderDetailsToView;
import com.driveUp.request.OrderDriverView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderViews")
@RequiredArgsConstructor
public class OrderViewsController {

    private final OrderConverter orderConverter;

    @PostMapping("convertFromOrder")
    public ResponseEntity<OrderDetailsToView> convert(@RequestBody Order order) {
        return new ResponseEntity<>(orderConverter.toOrderDetailsToView(order),
                HttpStatus.OK);
    }

    @PostMapping("createDriverView")
    public ResponseEntity<OrderDriverView> create(
            @RequestBody OrderDriverView view) {
        return new ResponseEntity<>(view, HttpStatus.OK);
    }
}
