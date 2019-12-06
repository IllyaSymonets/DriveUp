package com.softserve.service.provider.controller;

import com.softserve.service.provider.model.Motorcycle;
import com.softserve.service.provider.service.MotorcycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/motorcycle")
@RequiredArgsConstructor
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @PostMapping(path = "/add")
    public Motorcycle add(@RequestBody @NotNull Motorcycle motorcycle) {
        return motorcycleService.addMotorcycle(motorcycle);
    }

    @GetMapping(path = "/all")
    public Iterable<Motorcycle> getAll() {
        return motorcycleService.getAll();
    }

    @DeleteMapping(path = "/del/{id}")
    public void delete(@PathVariable UUID id) {
        motorcycleService.delMotorcycle(id);
    }
}
