package com.driveUp.controller;

import com.driveUp.pojo.BillingDto;
import com.driveUp.pojo.CreateTrip;
import com.driveUp.model.Route;
import com.driveUp.pojo.CreateTripRequest;
import com.driveUp.pojo.SetTripToOrderRequest;
import com.driveUp.service.MapsApiRequest;
import com.driveUp.service.MapsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

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
    private final KafkaTemplate<String, SetTripToOrderRequest> kafkaTemplate;
    private final String SET_TRIP_TOPIC="SET_TRIP_EVENT";

    //@PostMapping("/route")
    @KafkaListener(topics = "CREATE_TRIP_EVENT", containerFactory = "kafkaListenerContainerFactory")
    public void sendRequestToGoogleAPI(@RequestBody CreateTripRequest createTripRequest) {
        CreateTrip createTrip = createTripRequest.getTripInfo();
        String consumeJSONString = mapsApiRequest.postMapsApiRequest(
                createTrip.getOrigins(), createTrip.getDestinations(), createTrip.getDepTime());
        kafkaTemplate.send(SET_TRIP_TOPIC, new SetTripToOrderRequest(
                createTripRequest.getOrderNumber(),
                mapsService.insertNewRout(
                        consumeJSONString, createTrip.getDepTime()).
                        getRoute_id()));
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
