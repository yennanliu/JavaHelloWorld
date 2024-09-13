package com.yen.example2;

import com.google.inject.Inject;

public class Driver {

    private Car car;

    @Inject
    Driver(Car car){
        this.car = car;
    }

    public Car getCar(){
        return car; // this.car ?
    }

}
