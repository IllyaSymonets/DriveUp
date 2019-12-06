package notifications.service.generator.store;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum NotificationStore {

    MESSAGE_DRIVER_PROFILE("You are in a Driver-profile now"),
    MESSAGE_TRIP_STARTED("Your trip was started"),
    MESSAGE_TRIP_FINISHED_TO_CUSTOMER("The trip was finished. Please, give your feedback to your driver"),
    MESSAGE_TRIP_FINISHED_TO_DRIVER("The trip was finished. Please, give your feedback to your passenger"),
    MESSAGE_PAYED_BY_CASH("The order was payed by cash. Thank you!"),
    MESSAGE_PAYED_BY_BANK("The order was payed by bank. Thank you! " +
            "If you want to get the bank-check to your email, please press the button.");

    private String text;

    NotificationStore(String text) {
        this.text = text;
    }
}
