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
    public ResponseEntity addCar(@RequestBody @NotNull CarDTO carDTO) {
        carService.add(carDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(path = "/add/{id}")
    public ResponseEntity addCarByDriverId(@PathVariable UUID id,
                                           @RequestBody @NotNull CarDTO carDTO) {
        carService.addById(id, carDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteCarById(@PathVariable UUID id) {
        carService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
