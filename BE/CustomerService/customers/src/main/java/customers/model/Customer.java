package customers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "phone", nullable = false, length = 13)
    private String phone;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Email
    @Column(name = "email", length = 30)
    private String email = "";

    @Column(name = "customer_first_name", length = 25)
    private String firstName = "";

    @Column(name = "customer_second_name", length = 25)
    private String secondName = "";

//    @Column(name = "city", nullable = false, length = 20)
//    private String city = "";

    public Customer(@JsonProperty("phone") String phone,
                    @JsonProperty("password") String password) {
        this.phone = phone;
        this.password = password;
    }


}
