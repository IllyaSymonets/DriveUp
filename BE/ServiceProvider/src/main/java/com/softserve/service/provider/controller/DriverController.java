package com.softserve.service.provider.controller;

import com.softserve.service.provider.dto.*;
import com.softserve.service.provider.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<DriverDTO>> getAll() {
        Iterable<DriverDTO> drivers = driverService.getAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @GetMapping(path = "/rating/{id}")
    public ResponseEntity<DriverRatingDTO> getRating(@PathVariable UUID id) {
        DriverRatingDTO dto = DriverRatingDTO.builder()
                .rating(driverService.getRating(id))
                .build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(path = "/profile/{id}")
    public ResponseEntity<DriverProfileDTO> getProfile(@PathVariable UUID id) {
        DriverProfileDTO dto = driverService.getProfile(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(path = "/find")
    public List<UUID> getDriverId(@RequestBody @NotNull SearchCarDTO searchCarDTO) {
        return driverService.findId(searchCarDTO);
    }

    @PostMapping(path = "/add")
    public ResponseEntity addDriver(@RequestBody @NotNull DriverDTO driverDTO) {
        driverService.add(driverDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(path = "/fine/update/{id}")
    public ResponseEntity updateFine(@PathVariable UUID id,
                                     @NotNull @RequestBody DriverFineDTO driverFineDTO) {
        driverService.updateFine(id, driverFineDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/rating/update/{id}")
    public ResponseEntity updateRating(@PathVariable UUID id) {
        driverService.updateRating(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity updateDriver(@PathVariable UUID id,
                                       @NotNull @RequestBody DriverDTO driverDTO) {
        driverService.updateDriver(id, driverDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
