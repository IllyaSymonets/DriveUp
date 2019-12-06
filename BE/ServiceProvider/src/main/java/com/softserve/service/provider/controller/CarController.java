package com.softserve.service.provider.controller;

import com.softserve.service.provider.dto.CarDTO;
import com.softserve.service.provider.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<CarDTO>> getAll() {
        Iterable<CarDTO> cars = carService.getAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public CarDTO addCar(@RequestBody @NotNull CarDTO carDTO) {
        return carService.add(carDTO);
    }

    @PostMapping(path = "/add/{id}")
    public CarDTO addCarByDriverId(@PathVariable UUID id,
                                   @RequestBody @NotNull CarDTO carDTO) {
        return carService.addById(id, carDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.delete(id);
    }
}
