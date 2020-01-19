package customers.service;

import com.google.gson.Gson;
import customers.dto.CreateCustomerAndDriverRequest;
import customers.dto.CreateCustomerDto;
import customers.dto.DriverDTO;
import customers.model.Customer;
import customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

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
    public Customer updatePassword(UUID customerId, String oldPassword, String newPassword) {
        Customer customer = getCustomerById(customerId);
        if (customer.getPassword().equals(oldPassword)) {
            customer.setPassword(newPassword);
        }
        return customerRepository.save(customer);
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
