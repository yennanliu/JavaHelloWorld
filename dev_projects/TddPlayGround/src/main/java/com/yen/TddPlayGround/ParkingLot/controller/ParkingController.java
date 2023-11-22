package com.yen.TddPlayGround.ParkingLot.controller;

import com.yen.TddPlayGround.ControllerMockTest.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/parking")
@RestController
public class ParkingController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){

        return ResponseEntity.ok("hello !!!");
    }

}
