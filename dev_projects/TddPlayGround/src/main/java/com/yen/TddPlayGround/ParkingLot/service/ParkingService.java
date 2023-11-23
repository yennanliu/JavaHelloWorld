package com.yen.TddPlayGround.ParkingLot.service;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;

public interface ParkingService {

    public boolean isFull(String parkingLotId);

    // park a car in parking lot
    public boolean park(String carId, String parkingLotId);

    public int getAvailableSpace(String parkingLotId);

    // leave parking lot
    public boolean leave(String carId, String parkingLotId);

    ParkingLot getById(String parkinglot_id);
}
