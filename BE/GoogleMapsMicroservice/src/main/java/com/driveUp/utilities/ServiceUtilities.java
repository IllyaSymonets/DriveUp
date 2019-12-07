package com.driveUp.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilities {

    public static String parseTime(String time) {
        //2019-12-30T18:25:30Z
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        long timeInSeconds = localDateTime.toEpochSecond(ZoneOffset.UTC);
        return Long.toString(timeInSeconds);
    }

    public static String getPlacesId(JSONArray arr, int index, String placeId) {
        return arr.getJSONObject(index)
                .getString(placeId);
    }

    public static String getPlacesType(JSONArray arr, int index, String types, int index2) {
        return arr.getJSONObject(index)
                .getJSONArray(types)
                .getString(index2);
    }

    public static String getPolyline(JSONObject obj, String routes, int index,
                                     String overview_polyline, String points) {
        return obj.getJSONArray(routes)
                .getJSONObject(index)
                .getJSONObject(overview_polyline)
                .getString(points);
    }

    public static String getAddresses(JSONObject obj, String address) {
        return obj.getString(address);
    }

    public static List<Double> getCoordinates(JSONObject obj, String location) {
        JSONObject loc = obj.getJSONObject(location);
        Double lng = getCoord(loc, "lng");
        Double lat = getCoord(loc, "lat");
        return doubleList(lng, lat);
    }

    private static Double getCoord(JSONObject obj, String coord) {
        return obj.getDouble(coord);
    }

    private static List<Double> doubleList(Double lng, Double lat) {
        List<Double> coord = new ArrayList<>();
        coord.add(lng);
        coord.add(lat);
        return coord;
    }

    public static float getDistance(JSONObject obj, String distance, String text) {
        String dist = obj.getJSONObject(distance)
                .getString(text);
        return floatParser(dist);
    }

    public static float floatParser(String s) {
        String[] substring = s.split(" ");
        String str = substring[0];
        return Float.parseFloat(str);
    }
}
