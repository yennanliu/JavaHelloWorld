package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;

public class A_ParlongLot implements ParkingService {

    @Override
    public boolean isFull(String id) {
        return false;
    }

    @Override
    public String park(Car car, ParkingLot parkingLot) {
        return null;
    }

    @Override
    public int getAvailableSpace(String parkingLotId) {
        return 0;
    }

    @Override
    public String leave(Car car, ParkingLot parkingLot) {
        return null;
    }

}
