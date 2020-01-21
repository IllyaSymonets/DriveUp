package customers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private String phone;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
}