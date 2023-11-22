package com.yen.TddPlayGround.ParkingLot.bean;

import java.util.List;

public class ParkingLot {

    // attr
    private String id;

    private int size;
    private List<ParkingSpace> spaces;

    // constructor
    public ParkingLot(){

    }

    public ParkingLot(String id, int size, List<ParkingSpace> spaces) {
        this.id = id;
        this.size = size;
        this.spaces = spaces;
    }

    // method
    public int getFreeAmount(){

        int occupiedCount = (int) this.getSpaces().stream()
                .filter(x -> x.getStatus().equals("occupied")).count();
        return this.size - occupiedCount;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
                ", size=" + size +
                ", spaces=" + spaces +
                '}';
    }

}
