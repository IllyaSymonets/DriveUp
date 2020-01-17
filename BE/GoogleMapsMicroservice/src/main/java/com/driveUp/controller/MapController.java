package com.driveUp.controller;

import com.driveUp.dto.BillingDto;
import com.driveUp.dto.UserAddressesDto;
import com.driveUp.model.Route;
import com.driveUp.service.MapsApiRequest;
import com.driveUp.service.MapsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maps")
public class MapController {

    private final MapsService mapsService;
    private final MapsApiRequest mapsApiRequest;
    private HttpHeaders httpHeaders = new HttpHeaders();
    @LoadBalanced
    //private RestTemplate restTemplate;

    @PostMapping("/route")
    public void sendRequestToGoogleAPI(@RequestBody UserAddressesDto userAddressesDto) {
        String consumeJSONString = mapsApiRequest.postMapsApiRequest(
                userAddressesDto.getOrigins(), userAddressesDto.getDestinations(), userAddressesDto.getDepTime());
        mapsService.insertNewRout(consumeJSONString, userAddressesDto.getOrderId(), userAddressesDto.getDepTime());
    }

    @GetMapping("/retrieve-all")
    public ResponseEntity<List<Route>> getAllRouts() {
        List<Route> route = mapsService.getAllRouts();
        return new ResponseEntity<>(route, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/get-distance/{order-id}")
    public ResponseEntity<BillingDto> getDistance(@PathVariable("order-id") long id) {
        BillingDto billingDto = mapsService.getDistance(id);
        return new ResponseEntity<>(billingDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Route> getByRouteId(@PathVariable("id") UUID id) {
        return mapsService.getById(id);
    }
}
