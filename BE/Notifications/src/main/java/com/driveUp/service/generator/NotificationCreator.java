package com.driveUp.service.generator;

import com.driveUp.dto.ApprovedOrderDto;
import com.driveUp.dto.CreatedOrderDto;
import com.driveUp.dto.CreatedOrderDtoWithDrivers;
import com.driveUp.model.PhoneNotification;
import com.driveUp.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class NotificationCreator {

    private final NotificationRepository notificationRepository;

    public PhoneNotification createNotificationToCustomer(CreatedOrderDto orderDto, String message) {
        PhoneNotification phoneNotification = new PhoneNotification(orderDto.getCustomerId(), getCurrentTime(),
                message, orderDto.getCustomerPhone(), orderDto.getOrderId());
        notificationRepository.save(phoneNotification);
        return phoneNotification;
    }

    public PhoneNotification createNotificationToCustomer(ApprovedOrderDto orderDto, String message) {
        PhoneNotification phoneNotification = new PhoneNotification(orderDto.getCustomerId(), getCurrentTime(),
                message, orderDto.getCustomerPhone(), orderDto.getOrderId());
//        notificationRepository.save(phoneNotification);
        return phoneNotification;
    }

    public PhoneNotification createNotificationToDriver(ApprovedOrderDto orderDto, String message) {
        PhoneNotification phoneNotification = new PhoneNotification(orderDto.getCustomerId(), getCurrentTime(),
                message, orderDto.getDriverPhone(), orderDto.getOrderId());
        notificationRepository.save(phoneNotification);
        return phoneNotification;
    }

    public PhoneNotification createNotificationToDriver(CreatedOrderDtoWithDrivers orderDto, String driverPhone,
                                                        String message) {
        PhoneNotification phoneNotification = new PhoneNotification(orderDto.getCustomerId(), getCurrentTime(),
                message, driverPhone, orderDto.getOrderId());
        notificationRepository.save(phoneNotification);
        return phoneNotification;
    }

    private String getCurrentTime() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd HH:mm");
//        String dataAndTime = dt.format(new Date());
        String dataAndTime = "now";
        return dataAndTime;
    }
}
