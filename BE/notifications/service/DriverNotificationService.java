package notifications.service;

import lombok.RequiredArgsConstructor;
import notifications.dto.ApprovedOrderDto;
import notifications.dto.CreatedOrderDtoWithDrivers;
import notifications.dto.DriverInfo;
import notifications.model.PhoneNotification;
import notifications.service.generator.DriverNotificationsGenerator;
import notifications.service.generator.NotificationCreator;
import notifications.service.generator.store.NotificationStore;
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
