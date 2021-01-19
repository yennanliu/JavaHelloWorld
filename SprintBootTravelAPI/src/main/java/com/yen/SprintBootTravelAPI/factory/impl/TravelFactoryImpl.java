package com.yen.SprintBootTravelAPI.factory.impl;

import com.yen.SprintBootTravelAPI.enumeration.TravelTypeEnum;
import com.yen.SprintBootTravelAPI.factory.TravelFactory;
import com.yen.SprintBootTravelAPI.model.Travel;

public class TravelFactoryImpl implements TravelFactory {
    @Override
    public Travel createTravel(String type) {
        if (TravelTypeEnum.ONE_WAY.getValue().equals(type)) {
            return new Travel(TravelTypeEnum.ONE_WAY);
        } else if (TravelTypeEnum.MULTI_CITY.getValue().equals(type)) {
            return new Travel(TravelTypeEnum.MULTI_CITY);
        }
        return new Travel(TravelTypeEnum.RETURN);
    }
}