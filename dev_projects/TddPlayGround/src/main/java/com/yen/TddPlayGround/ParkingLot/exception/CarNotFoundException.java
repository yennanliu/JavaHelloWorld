package com.yen.TddPlayGround.ParkingLot.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }

}
