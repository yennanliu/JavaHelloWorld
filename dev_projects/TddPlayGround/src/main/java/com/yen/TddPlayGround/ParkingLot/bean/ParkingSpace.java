package com.yen.TddPlayGround.ParkingLot.bean;

public class ParkingSpace {

    // attr
    private String carId;
    private String status;

    public ParkingSpace(){

    }

    // constructor
    public ParkingSpace(String carId, String status){
        this.carId = carId;
        this.status = status;
    }

    public String getId() {
        return carId;
    }

    public void setId(String carId) {
        this.carId = carId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "carId='" + carId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
