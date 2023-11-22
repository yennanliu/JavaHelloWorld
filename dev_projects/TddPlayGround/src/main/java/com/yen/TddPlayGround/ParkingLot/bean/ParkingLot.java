package com.yen.TddPlayGround.ParkingLot.bean;

import java.util.List;

public class ParkingLot {

    // attr
    private String id;
    private List<ParkingSpace> spaces;

    public ParkingLot(){

    }

    public ParkingLot(String id, List<ParkingSpace> spaces) {
        this.id = id;
        this.spaces = spaces;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingSpace> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<ParkingSpace> spaces) {
        this.spaces = spaces;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "id='" + id + '\'' +
                ", spaces=" + spaces +
                '}';
    }

}
