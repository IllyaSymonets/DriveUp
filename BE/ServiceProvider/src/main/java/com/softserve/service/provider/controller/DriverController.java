package com.softserve.service.provider.controller;

import com.softserve.service.provider.dto.DriverDTO;
import com.softserve.service.provider.dto.DriverProfileDTO;
import com.softserve.service.provider.dto.DriverRatingDTO;
import com.softserve.service.provider.request.DriverFineRequest;
import com.softserve.service.provider.request.AddDriverRequest;
import com.softserve.service.provider.request.SearchCarRequest;
import com.softserve.service.provider.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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
    private final KafkaTemplate<String, String> kafkaTemplate;

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
        kafkaTemplate.send("customer", "c6f2526f-01c5-48a2-87ab-0ed76f47371e");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(path = "/find/car")
    public ResponseEntity<List<UUID>> getDriverId(@RequestBody @NotNull @Valid SearchCarRequest searchCarRequest) {
        List<UUID> uuidList = driverService.findDrivers(searchCarRequest);
        return new ResponseEntity<>(uuidList, HttpStatus.OK);
    }

//    @PostMapping(path = "/add")
//    public ResponseEntity addDriver(@RequestBody @NotNull @Valid AddDriverRequest addDriverRequest) {
//        driverService.add(addDriverRequest);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

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
