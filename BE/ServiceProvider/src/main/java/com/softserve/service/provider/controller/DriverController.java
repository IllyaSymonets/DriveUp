package com.softserve.service.provider.controller;

import com.softserve.service.provider.dto.DriverDTO;
import com.softserve.service.provider.dto.DriverFineDTO;
import com.softserve.service.provider.dto.DriverProfileDTO;
import com.softserve.service.provider.dto.DriverRatingDTO;
import com.softserve.service.provider.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    @PostMapping(path = "/add")
    public DriverDTO addDriver(@RequestBody @NotNull DriverDTO driverDTO) {
        return driverService.add(driverDTO);
    }

    @PutMapping(path = "/fine/update/{id}")
    public DriverDTO updateFine(@PathVariable UUID id,
                                @NotNull @RequestBody DriverFineDTO driverFineDTO) {
        return driverService.updateFine(id, driverFineDTO);
    }

    @PutMapping(path = "/rating/update/{id}")
    public DriverDTO updateRating(@PathVariable UUID id) {
        return driverService.updateRating(id);
    }

    @PutMapping(path = "/update/{id}")
    public DriverDTO updateDriver(@PathVariable UUID id,
                                  @NotNull @RequestBody DriverDTO driverDTO) {
        return driverService.updateDriver(id, driverDTO);
    }
}
