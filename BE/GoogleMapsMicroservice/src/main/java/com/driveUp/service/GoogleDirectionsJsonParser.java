package com.driveUp.service;

import com.driveUp.model.Route;
import com.driveUp.utilities.ServiceUtilities;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoogleDirectionsJsonParser implements JsonParser{

    public Route parseJSON(String jsonObject, long orderId, String departureTime) {

        JSONObject obj = new JSONObject(jsonObject);

        JSONArray places = obj.getJSONArray("geocoded_waypoints");

        String destPlaceId = ServiceUtilities.getPlacesId(places, 0, "place_id");
        String startPlaceId = ServiceUtilities.getPlacesId(places, 1, "place_id");
        String destType = ServiceUtilities.getPlacesType(places, 0, "types", 0);
        String startType = ServiceUtilities.getPlacesType(places, 1, "types", 0);
        String polyline = ServiceUtilities.getPolyline(obj, "routes", 0,
                "overview_polyline", "points");

        JSONObject addresses = obj.getJSONArray("routes")
                .getJSONObject(0)
                .getJSONArray("legs")
                .getJSONObject(0);

        String startAddress = ServiceUtilities.getAddresses(addresses, "end_address");
        String endAddress = ServiceUtilities.getAddresses(addresses, "start_address");
        List<Double> destCoord = ServiceUtilities.getCoordinates(addresses, "end_location");
        List<Double> startCoord = ServiceUtilities.getCoordinates(addresses, "start_location");
        float distance = ServiceUtilities.getDistance(addresses, "distance", "text");

        return new Route(orderId, startAddress, endAddress, distance, startCoord,
                startType, startPlaceId, destCoord, destType, destPlaceId, polyline, departureTime);
    }
}
