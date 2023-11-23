package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingSpace;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class A_ParkingLot implements ParkingService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public boolean isFull(ParkingLot parkingLot) {

        return parkingLot.getFreeAmount() == 0;
    }

    @Override
    public boolean park(Car car, ParkingLot parkingLot) {

        if(parkingLot.getFreeAmount() == 0){
            System.out.println("No free space in parking lot");
            return false;
        }
        List<ParkingSpace> parkingSpaceList = parkingLot.getSpaces();
        parkingSpaceList.add(new ParkingSpace(car.getId(), "occupied"));
        return true;
    }

    @Override
    public int getAvailableSpace(ParkingLot parkingLot) {

        return parkingLot.getFreeAmount();
    }

    @Override
    public boolean leave(Car car, ParkingLot parkingLot) {

        List<ParkingSpace> spaces = parkingLot
                .getSpaces();

        List<String> carList = spaces
                .stream()
                .filter(x -> x.getStatus().equals("occupied"))
                .filter(x -> x.getId().equals(car.getId()))
                .map(x -> x.getId()).collect(Collectors.toList());

        if (carList.size() == 0){
            System.out.println("No car in parking lot");
            return false;
        }

        if(parkingLot.getFreeAmount() < parkingLot.getSize()){
            // update parking space
            int idx = parkingLot.getCarIdx(car);
            System.out.println("remove car from parkingLot : " + car);
            spaces.remove(idx);
            return true;
        }

        System.out.println("No car to leave parking lot");
        return false;
    }

    @Override
    public ParkingLot getById(String parkinglot_id) {

        return parkingLotRepository.getReferenceById(parkinglot_id);
    }

}
