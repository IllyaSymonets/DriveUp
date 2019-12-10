package softserve.academy.domain;

import lombok.Getter;

@Getter
public enum PaymentType {
    Online("DIGITAL"),
    Offline("CASH");

    private String type;

    PaymentType(String type) {
        this.type = type;
    }
}
