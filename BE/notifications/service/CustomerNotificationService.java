package notifications.service;

import lombok.RequiredArgsConstructor;
import notifications.dto.ApprovedOrderDto;
import notifications.dto.CreatedOrderDto;
import notifications.model.PhoneNotification;
import notifications.service.generator.CustomerNotificationsGenerator;
import notifications.service.generator.NotificationCreator;
import notifications.service.generator.store.NotificationStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerNotificationService {
    private final CustomerNotificationsGenerator notificationGenerator;
    private final NotificationCreator notificationCreator;

    public PhoneNotification sayOrderCreated(CreatedOrderDto orderDto) {
        String message = notificationGenerator.getRegisteredOrderMess(orderDto.getOrderNumber());
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayApprovedOrderMess(ApprovedOrderDto orderDto) {
        String message = notificationGenerator.getConfirmedOrderMess(orderDto.getDriverPhone(),
                orderDto.getPrice(),
                orderDto.getWishTime());
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayCarArrivedMess(ApprovedOrderDto orderDto) {
        String message = notificationGenerator.getCarArrived(orderDto.getBrand(), orderDto.getModel(),
                orderDto.getColor(), orderDto.getLicencePlate());
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayTripStarted(ApprovedOrderDto orderDto) {
        String message = NotificationStore.MESSAGE_TRIP_STARTED.getText();
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayTripFinished(ApprovedOrderDto orderDto) {
        String message = NotificationStore.MESSAGE_TRIP_FINISHED_TO_CUSTOMER.getText();
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayPayedByCash(ApprovedOrderDto orderDto) {
        String message = NotificationStore.MESSAGE_PAYED_BY_CASH.getText();
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }

    public PhoneNotification sayPayedByBank(ApprovedOrderDto orderDto) {
        String message = NotificationStore.MESSAGE_PAYED_BY_BANK.getText();
        return notificationCreator.createNotificationToCustomer(orderDto, message);
    }
}
