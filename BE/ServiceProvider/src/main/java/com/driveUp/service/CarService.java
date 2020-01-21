package com.driveUp.service;

import com.driveUp.exception.DriverNotFoundException;
import com.driveUp.repository.CarRepository;
import com.driveUp.repository.DriverRepository;
import com.driveUp.request.CarRequest;
import com.driveUp.utilities.Constants;
import com.driveUp.dto.CarDTO;
import com.driveUp.model.Car;
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

    public void addById(UUID driverId, CarRequest carRequest) {
        driverRepository.findById(driverId)
                .map(driver -> {
                    Car car = getCar(carRequest);
                    driver.setCar(car);
                    car.setType(calculateType(car));
                    carRequest.setType(car.getType());
                    carRepository.save(car);
                    return carRequest;
                })
                .orElseThrow(() -> new DriverNotFoundException(driverId));
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

    private Car getCar(CarRequest carRequest) {
        return Car.builder()
                .babyCarSeat(carRequest.isBabyCarSeat())
                .conditioner(carRequest.isConditioner())
                .courier(carRequest.isCourier())
                .english(carRequest.isEnglish())
                .nonSmoker(carRequest.isNonSmoker())
                .numberOfSeats(carRequest.getNumberOfSeats())
                .pet(carRequest.isPet())
                .silence(carRequest.isSilence())
                .colour(carRequest.getColour())
                .model(carRequest.getModel())
                .brand(carRequest.getBrand())
                .licencePlate(carRequest.getLicencePlate())
                .yearOfProduction(carRequest.getYearOfProduction())
                .build();
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
}
