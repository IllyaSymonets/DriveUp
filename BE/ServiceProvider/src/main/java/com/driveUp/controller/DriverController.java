package com.driveUp.controller;

import com.driveUp.dto.DriverDTO;
import com.driveUp.dto.DriverProfileDTO;
import com.driveUp.dto.DriverRatingDTO;
import com.driveUp.request.AddDriverRequest;
import com.driveUp.request.DriverFineRequest;
import com.driveUp.request.SearchCarRequest;
import com.driveUp.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(path = "/find/car")
    public ResponseEntity<List<UUID>> getDriverId(
            @RequestBody @NotNull @Valid SearchCarRequest searchCarRequest) {
        List<UUID> uuidList = driverService.findDrivers(searchCarRequest);
        return new ResponseEntity<>(uuidList, HttpStatus.OK);
    }

    @PutMapping(path = "/fine/update/{id}")
    public ResponseEntity updateFine(@PathVariable UUID id,
                                     @NotNull @RequestBody @Valid DriverFineRequest driverFineRequest) {
        driverService.updateFine(id, driverFineRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/rating/update/{id}")
    public ResponseEntity updateRating(@PathVariable UUID id) {
        driverService.updateRating(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity updateDriver(@PathVariable UUID id,
                                       @NotNull @RequestBody @Valid AddDriverRequest addDriverRequest) {
        driverService.updateDriver(id, addDriverRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
