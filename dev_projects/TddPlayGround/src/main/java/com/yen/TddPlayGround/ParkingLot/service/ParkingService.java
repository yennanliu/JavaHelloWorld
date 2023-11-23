package com.yen.TddPlayGround.ParkingLot.service;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;

public interface ParkingService {

    public boolean isFull(String parkingLotId);

    // park a car in parking lot
    public boolean park(String carId, String parkingLotId);

    public int getAvailableSpace(ParkingLot parkingLot);

    // leave parking lot
    public boolean leave(Car car, ParkingLot parkingLot);

    ParkingLot getById(String parkinglot_id);
}
