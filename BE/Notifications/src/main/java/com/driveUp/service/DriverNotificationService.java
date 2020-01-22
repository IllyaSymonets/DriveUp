package com.driveUp.service;

import com.driveUp.dto.ApprovedOrderDto;
import com.driveUp.dto.CreatedOrderDtoWithDrivers;
import com.driveUp.dto.DriverInfo;
import com.driveUp.model.PhoneNotification;
import com.driveUp.service.generator.DriverNotificationsGenerator;
import com.driveUp.service.generator.NotificationCreator;
import com.driveUp.service.generator.store.NotificationStore;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverNotificationService {
    private final DriverNotificationsGenerator notificationGenerator;
    private final NotificationCreator notificationCreator;

    private PhoneNotification sayOrderCreated(CreatedOrderDtoWithDrivers orderDto, String driverPhone) {
        String message = notificationGenerator.getRegisteredOrderMess(orderDto.getCustomerPhone(),
                orderDto.getWishTime(), orderDto.getStartAddress(), orderDto.getFinishAddress());
        return notificationCreator.createNotificationToDriver(orderDto, driverPhone, message);
    }

    public List<PhoneNotification> sayToDriversOrderCreated(CreatedOrderDtoWithDrivers createdOrderDtoWithDrivers) {
        List<PhoneNotification> phoneNotificationList = new ArrayList<>();

        List<DriverInfo> driverList = createdOrderDtoWithDrivers.getListOfDrivers();
        for (DriverInfo driver : driverList) {
            PhoneNotification phoneNotification = sayOrderCreated(createdOrderDtoWithDrivers,
                    driver.getDriverPhone());
            phoneNotificationList.add(phoneNotification);
        }
        return phoneNotificationList;
    }

    public PhoneNotification sayOrderConfirmed(ApprovedOrderDto orderDto) {
        String message = notificationGenerator.getConfirmedOrderMess(orderDto.getOrderNumber(),
                orderDto.getCustomerPhone(), orderDto.getWishTime(), orderDto.getStartAddress());
        return notificationCreator.createNotificationToDriver(orderDto, message);
    }

    public PhoneNotification sayTripFinished(ApprovedOrderDto orderDto) {
        String message = NotificationStore.MESSAGE_TRIP_FINISHED_TO_DRIVER.getText();
        return notificationCreator.createNotificationToDriver(orderDto, message);
    }
}
