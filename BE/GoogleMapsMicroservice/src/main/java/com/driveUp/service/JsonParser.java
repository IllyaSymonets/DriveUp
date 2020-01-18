package com.driveUp.service;

import com.driveUp.model.Route;

public interface JsonParser {

    Route parseJSON(String jsonObject, String departureTime);

}
