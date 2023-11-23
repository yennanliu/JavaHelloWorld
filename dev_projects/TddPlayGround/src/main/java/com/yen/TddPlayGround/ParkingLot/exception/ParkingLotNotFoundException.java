package com.yen.TddPlayGround.ParkingLot.exception;

public class ParkingLotNotFoundException extends RuntimeException{

    private static final long serialVerisionUID = 1234235;

    public ParkingLotNotFoundException(String message){
        super(message);
    }
}
