package customers.listener;

import com.google.gson.Gson;
import customers.dto.CustomerDTO;
import customers.model.Customer;
import customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Listener {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomerRepository customerRepository;
    private final Gson jsonConverter;

    @KafkaListener(topics = "customer")
    public void getCustomerDTO(String id) {
        System.out.println(id);
        UUID uuid = UUID.fromString(id);
        Optional<Customer> customer = customerRepository.findById(uuid);

        if (customer.isPresent()) {
            CustomerDTO customerDTO = CustomerDTO.builder()
                    .email(customer.get().getEmail())
                    .password(customer.get().getPassword())
                    .firstName(customer.get().getFirstName())
                    .secondName(customer.get().getSecondName())
                    .phone(customer.get().getPhone())
                    .build();
            kafkaTemplate.send("driver", jsonConverter.toJson(customerDTO));
        } else {
            throw new RuntimeException(String.format("There is no user with such id : %s", id));
        }
    }
}
