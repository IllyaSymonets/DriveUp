package com.softserve.service.provider.listener;

import com.google.gson.Gson;
import com.softserve.service.provider.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Listener {
    private final Gson jsonConverter;

    @KafkaListener(topics = "driver")
    public void getFromCustomer(String customerDTO) {
        CustomerDTO dto = jsonConverter.fromJson(customerDTO, CustomerDTO.class);
        System.out.println(dto);
    }
}
