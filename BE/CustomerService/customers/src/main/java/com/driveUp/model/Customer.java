package com.driveUp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "phone", nullable = false, unique = true, length = 13)
    private String phone;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 2, max = 30)
    private String password;

    @Email
    @Column(name = "email", length = 30)
    private String email = "";

    @Column(name = "customer_first_name", length = 25)
    private String firstName = "";

    @Column(name = "customer_second_name", length = 25)
    private String secondName = "";

    @Column(name = "city", nullable = false, length = 20)
    private String city = "Dnipro";

    public Customer(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
