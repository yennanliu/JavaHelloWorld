package com.yen.TddPlayGround.ParkingLot.controller;

import com.yen.TddPlayGround.ControllerMockTest.Response;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import com.yen.TddPlayGround.ParkingLot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/parking")
@RestController
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){

        return ResponseEntity.ok("hello !!!");
    }

    @GetMapping("/size/{parkinglot_id}")
    public ResponseEntity<String> getParkingSize(@PathVariable String parkinglot_id){

       ParkingLot parkingLot = parkingService.getById(parkinglot_id);
       int size = parkingLot.getSize();
       return ResponseEntity.ok("size = " + size);
    }

    @GetMapping("/freeSpace/{parkinglot_id}")
    public ResponseEntity<String> getParkingFreeSpace(@PathVariable String parkinglot_id){

        ParkingLot parkingLot = parkingService.getById(parkinglot_id);
        int size = parkingLot.getFreeAmount();
        return ResponseEntity.ok("free space size = " + size);
    }

    @GetMapping("/park/parkinglot_id/{car_id}")
    public ResponseEntity<String> park_car(@PathVariable String parkinglot_id, @PathVariable String car_id){

//        ParkingLot parkingLot = parkingService.park(parkinglot_id, car_id);
//        int size = parkingLot.getFreeAmount();
          return ResponseEntity.ok("park car OK");
    }

}
