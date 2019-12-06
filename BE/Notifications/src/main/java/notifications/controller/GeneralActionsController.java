package notifications.controller;

import lombok.RequiredArgsConstructor;
import notifications.model.PhoneNotification;
import notifications.service.GeneralNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notifications/get")
@RequiredArgsConstructor
public class GeneralActionsController {

    private final GeneralNotificationService generalNotificationService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<PhoneNotification>> getAll() {
        Iterable<PhoneNotification> listOfNotification =
                            generalNotificationService.getAllPhoneNotifications();
        return new ResponseEntity<>(listOfNotification, HttpStatus.OK);
    }

    @PostMapping("/allByOrderId")
    public ResponseEntity<Iterable<PhoneNotification>> getAllByOrderId() {
        Iterable<PhoneNotification> listOfNotification =
                            generalNotificationService.getAllPhoneNotifications();
        return new ResponseEntity<>(listOfNotification, HttpStatus.OK);
    }
}
