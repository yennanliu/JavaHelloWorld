package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingSpace;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;

import java.util.List;

public class A_ParkingLot implements ParkingService {

    @Override
    public boolean isFull(ParkingLot parkingLot) {

        return parkingLot.getFreeAmount() == 0;
    }

    @Override
    public boolean park(Car car, ParkingLot parkingLot) {
        if(parkingLot.getFreeAmount() == 0){
            return false;
        }
        List<ParkingSpace> parkingSpaceList = parkingLot.getSpaces();
        // TODO : optimize below
        parkingSpaceList.add(new ParkingSpace("p-01", "occupied"));
        return true;
    }

    @Override
    public int getAvailableSpace(ParkingLot parkingLot) {
        return parkingLot.getFreeAmount();
    }

    @Override
    public boolean leave(Car car, ParkingLot parkingLot) {
        if(parkingLot.getFreeAmount() < parkingLot.getSize()){
            //parkingLot.
            return true;
        }
        System.out.println("No car to leave parking lot");
        return false;
    }

}
