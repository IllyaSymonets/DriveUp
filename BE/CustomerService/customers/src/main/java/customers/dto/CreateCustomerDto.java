package customers.dto;

import lombok.Data;

@Data
public class CreateCustomerDto {
    private String phone;
    private String password;
}
