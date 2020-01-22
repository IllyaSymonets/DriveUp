package com.driveUp.service;

import com.driveUp.config.ApiConfig;
import com.driveUp.utilities.ServiceUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GoogleDirectionsRequest implements MapsApiRequest {

    @Autowired
    private ApiConfig apiKey;

    public String postMapsApiRequest(String origin, String destination, String time) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://maps.googleapis.com/maps/api/directions/json?" +
                "origin={origin}&destination={destination}&departure_time={departure_time}&region=ua&key={apiKey}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("origin", origin);
        uriVariables.put("destination", destination);
        uriVariables.put("apiKey", apiKey.getConfigValue("googleApiKey"));
        uriVariables.put("departure_time", ServiceUtilities.parseTime(time));

        return restTemplate.getForObject(url, String.class, uriVariables);
    }
}

