package customers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateCustomerDto {

    private String phone;
    private String password;

    public CreateCustomerDto(@JsonProperty("name") String phone,
                             @JsonProperty("password") String password) {
        this.phone = phone;
        this.password = password;
    }
}
