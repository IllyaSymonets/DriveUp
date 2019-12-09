package com.softserve.service.provider.futureFeaturesNotToUse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping(path = "/truck")
@RequiredArgsConstructor
public class TruckController {

    private final TruckService truckService;

    @PostMapping(path = "/add")
    public Truck add(@RequestBody @NotNull Truck truck) {
        return truckService.addTruck(truck);
    }

    @GetMapping(path = "/all")
    public Iterable<Truck> getAll() {
        return truckService.getAll();
    }

    @DeleteMapping(path = "/del/{id}")
    public void delete(@PathVariable UUID id) {
        truckService.delTruck(id);
    }
}
