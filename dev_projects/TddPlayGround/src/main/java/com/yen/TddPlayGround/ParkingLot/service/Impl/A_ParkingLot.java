package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingSpace;
import com.yen.TddPlayGround.ParkingLot.exception.CarNotFoundException;
import com.yen.TddPlayGround.ParkingLot.exception.ParkingLotNotFoundException;
import com.yen.TddPlayGround.ParkingLot.repository.CarRepository;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class A_ParkingLot implements ParkingService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public boolean isFull(String parkingLotId) {

        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ParkingLotNotFoundException("ParkingLot Not found"));
        return parkingLot.getFreeAmount() == 0;
    }

    @Override
    public boolean park(String carId, String parkingLotId){

        // NOTE !!! below trick
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ParkingLotNotFoundException("ParkingLot Not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("Car Not found"));

        if(parkingLot.getFreeAmount() == 0){
            System.out.println("No free space in parking lot");
            return false;
        }
        List<ParkingSpace> parkingSpaceList = parkingLot.getSpaces();
        parkingSpaceList.add(new ParkingSpace(car.getId(), "occupied"));
        return true;
    }

    @Override
    public int getAvailableSpace(String parkingLotId) {

        // NOTE !!! below trick
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ParkingLotNotFoundException("ParkingLot Not found"));
        return parkingLot.getFreeAmount();
    }

    @Override
    public boolean leave(String carId, String parkingLotId) {

        // NOTE !!! below trick
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ParkingLotNotFoundException("ParkingLot Not found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("Car Not found"));

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
