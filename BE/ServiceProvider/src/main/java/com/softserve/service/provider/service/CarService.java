package com.softserve.service.provider.service;

import com.softserve.service.provider.consts.Constants;
import com.softserve.service.provider.dto.CarDTO;
import com.softserve.service.provider.model.Car;
import com.softserve.service.provider.repository.CarRepository;
import com.softserve.service.provider.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final DriverRepository driverRepository;

    public CarDTO add(CarDTO carDTO) {
        Car car = getCar(carDTO);
        car.setType(calculateType(car));
        carDTO.setType(car.getType());
        carRepository.save(car);
        return carDTO;
    }

    public CarDTO addById(UUID id, CarDTO carDTO) {
        return driverRepository.findById(id)
                .map(driver -> {
                    Car car = getCar(carDTO);
                    driver.setCar(car);
                    car.setType(calculateType(car));
                    carDTO.setType(car.getType());
                    carRepository.save(car);
                    return carDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    public Iterable<CarDTO> getAll() {
        Iterable<Car> cars = carRepository.findAll();
        List<CarDTO> dtos = new ArrayList<>();

        for (Car car : cars) {

            dtos.add(CarDTO.builder()
                    .type(car.getType())
                    .licencePlate(car.getLicencePlate())
                    .colour(car.getColour())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .yearOfProduction(car.getYearOfProduction())
                    .numberOfSeats(car.getNumberOfSeats())
                    .babyCarSeat(car.isBabyCarSeat())
                    .conditioner(car.isConditioner())
                    .pet(car.isPet())
                    .courier(car.isCourier())
                    .english(car.isEnglish())
                    .nonSmoker(car.isNonSmoker())
                    .silence(car.isSilence())
                    .build());
        }

        return dtos;
    }

    public void delete(UUID id) {
        carRepository.deleteById(id);
    }

    private String calculateType(Car car) {
        Calendar calendar = Calendar.getInstance();

        String type = "n/a";

        if (!car.isConditioner() && !car.isEnglish() && !car.isBabyCarSeat()) {
            type = Constants.ECONOM;
        }

        if (car.isEnglish() && car.isConditioner()) {
            type = Constants.BUSINESS;
        }

        if (car.getYearOfProduction() > (calendar.get(Calendar.YEAR) - 5) &&
                car.isConditioner() && car.isBabyCarSeat() && car.isEnglish() &&
                car.isNonSmoker() && car.isSilence()) {
            type = Constants.VIP;
        }

        if (car.getNumberOfSeats() > 4) {
            type = Constants.MINIVAN;
        }

        return type;
    }

    private Car getCar(CarDTO carDTO) {
        return Car.builder()
                .babyCarSeat(carDTO.isBabyCarSeat())
                .conditioner(carDTO.isConditioner())
                .courier(carDTO.isCourier())
                .english(carDTO.isEnglish())
                .nonSmoker(carDTO.isNonSmoker())
                .numberOfSeats(carDTO.getNumberOfSeats())
                .pet(carDTO.isPet())
                .silence(carDTO.isSilence())
                .colour(carDTO.getColour())
                .model(carDTO.getModel())
                .brand(carDTO.getBrand())
                .licencePlate(carDTO.getLicencePlate())
                .yearOfProduction(carDTO.getYearOfProduction())
                .build();
    }
}
