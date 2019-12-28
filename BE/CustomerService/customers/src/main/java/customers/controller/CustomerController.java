package customers.controller;

import customers.dto.CreateCustomerDto;
import customers.model.Customer;
import customers.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping(path = "/save" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Customer> save(CreateCustomerDto customerDto) {
        Customer customer = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Customer> changePassword(@PathVariable UUID customerId,
                                                   @PathVariable String oldPassword,
                                                   @PathVariable String newPassword) {
        Customer customer = customerService.updatePassword(customerId, oldPassword, newPassword);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID customerId, String email,
                                                   String firstName, String secondName) {
        Customer customer = customerService.updateCustomer(customerId, email, firstName, secondName);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/get_customer_by_id")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/get_email_by_id")
    public ResponseEntity<String> getEmailById(@PathVariable UUID customerId) {
        String email = customerService.getEmailById(customerId);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    @GetMapping("/get_phone_by_id")
    public ResponseEntity<String> getPhoneById(@PathVariable UUID customerId) {
        String phone = customerService.getPhoneById(customerId);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @GetMapping("/get_all")
    public ResponseEntity getAll() {
        Iterable listOfCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(listOfCustomers, HttpStatus.OK);
    }
}
