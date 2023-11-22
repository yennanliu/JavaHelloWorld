package com.yen.TddPlayGround.ParkingLot.bean;

public class ParkingSpace {

    // attr
    private String id;
    private String status;

    public ParkingSpace(){

    }

    // constructor
    public ParkingSpace(String id, String status){
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
