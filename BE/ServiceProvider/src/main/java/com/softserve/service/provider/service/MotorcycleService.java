package com.softserve.service.provider.service;

import com.softserve.service.provider.consts.Constants;
import com.softserve.service.provider.model.Motorcycle;
import com.softserve.service.provider.repository.MotorcycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;

    public Motorcycle addMotorcycle(Motorcycle motorcycle) {
        motorcycle.setType(calculateType(motorcycle));
        return motorcycleRepository.save(motorcycle);
    }

    public Iterable<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    public void delMotorcycle(UUID id) {
        motorcycleRepository.deleteById(id);
    }


    private String calculateType(Motorcycle motorcycle) {
        Calendar calendar = Calendar.getInstance();
        String type = "n/a";

        if (motorcycle.getYearOfProduction() > (calendar.get(Calendar.YEAR) - 20)) {
            type = Constants.SUPER;
        }

        return type;
    }
}
