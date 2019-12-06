package softserve.academy.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {

    CREATED("Created"),
    DRIVER_WAS_FOUND("With driver"),
    DRIVER_WAITING("Driver waiting"),
    ORDER_IN_PROGRESS("In progress"),
    ORDER_COMPLETED("Completed");



    private String status;

    OrderStatus(String status) {
        this.status = status;
    }
}
