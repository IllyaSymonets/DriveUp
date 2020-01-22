package com.driveUp.service;

import lombok.RequiredArgsConstructor;
import com.driveUp.model.PhoneNotification;
import com.driveUp.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeneralNotificationService {

    private final NotificationRepository notificationRepository;

    public Iterable<PhoneNotification> getAllPhoneNotifications() {
        return notificationRepository.findAll();
    }

    public Iterable<PhoneNotification> getAllByOrderIds(UUID orderId) {
        return notificationRepository.findAllByOrderId(orderId);
    }
}
