package com.driveUp.service;

import com.driveUp.dto.ChangePasswordDto;
import com.driveUp.dto.CreateCustomerAndDriverRequest;
import com.driveUp.dto.CreateCustomerDto;
import com.driveUp.dto.DriverDTO;
import com.driveUp.model.Customer;
import com.driveUp.repository.CustomerRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    public void addCustomerAndDriver(CreateCustomerAndDriverRequest createCustomerAndDriverRequest) {

        Customer customer = addCustomer(createCustomerAndDriverRequest);

        Customer newCustomer = customerRepository.getCustomerByPhone(customer.getPhone());
        UUID customerId = newCustomer.getCustomerId();

        DriverDTO driverDTO = new DriverDTO(customerId,
                createCustomerAndDriverRequest.getCity(), createCustomerAndDriverRequest.getLicence());

        kafkaTemplate.send("driver", jsonConverter.toJson(driverDTO));
    }

    private Customer addCustomer(CreateCustomerAndDriverRequest createCustomerAndDriverRequest) {
        Customer customer = Customer.builder()
                .password(createCustomerAndDriverRequest.getPassword())
                .phone(createCustomerAndDriverRequest.getPhone())
                .email(createCustomerAndDriverRequest.getEmail())
                .firstName(createCustomerAndDriverRequest.getFirstName())
                .secondName(createCustomerAndDriverRequest.getSecondName())
                .build();
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer saveCustomer(CreateCustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getPhone(), customerDto.getPassword());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updatePassword(ChangePasswordDto changePasswordDto) {
        Optional<Customer> customer = Optional.ofNullable(
                getCustomerById(changePasswordDto.getCustomerId()));
        if(customer.isPresent()){
           if(customer.get().getPassword().equals(changePasswordDto.getOldPassword())) {
               customer.get().setPassword(changePasswordDto.getNewPassword());
           }
           //else save of old password - but customer will not see the mistake!
        }
        //what to do if customer is null?
        return customerRepository.save(customer.get());
        //add exception handling the situation when customer is not exists
    }

    @Override
    public Customer updateCustomer(UUID customerId, String email, String firstName, String secondName) {
        Customer customer = getCustomerById(customerId);
        customer.setEmail(email);
        customer.setFirstName(firstName);
        customer.setSecondName(secondName);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public String getEmailById(UUID customerId) {
        return customerRepository.findById(customerId).get().getEmail();
    }

    @Override
    public String getPhoneById(UUID customerId) {
        return customerRepository.findById(customerId).get().getPhone();
    }

    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
