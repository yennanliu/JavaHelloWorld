package com.yen.TddPlayGround.ParkingLot.bean;

public class Car {
    private String id;

    public Car(){

    }

    public Car(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                '}';
    }

}
