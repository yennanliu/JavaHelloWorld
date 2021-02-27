package com.yen.SprintBootTravelAPI.factory;

import com.yen.SprintBootTravelAPI.model.Travel;

public interface TravelFactory {
    Travel createTravel (String type);
}