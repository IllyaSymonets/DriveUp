package customers.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CreateCustomerAndDriverRequest {
    private String phone;
    private String password;
    private String email;
    private String firstName;
    private String secondName;

    @Size(min = 4, max = 50)
    private String city;

    @Size(min = 4, max = 10)
    private String licence;
}
