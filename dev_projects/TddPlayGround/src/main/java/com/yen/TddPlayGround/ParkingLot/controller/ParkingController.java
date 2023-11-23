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

    @GetMapping("/parkSize/{parkinglot_id}")
    public ResponseEntity<String> getParkingSize(@PathVariable String parkinglot_id){
       ParkingLot parkingLot = parkingService.getById(parkinglot_id);
       int size = parkingLot.getSize();
       return ResponseEntity.ok("size = " + size);
    }

}
