package com.driveUp.repository;

import com.driveUp.model.PhoneNotification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends CrudRepository<PhoneNotification, UUID> {

    List<PhoneNotification> findAllByOrderId(UUID orderId);
}
