package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class A_ParkingLot_Test {

    @InjectMocks
    A_ParkingLot a_parkingLot;

    ParkingLot parkingLot_a;

    ParkingLot parkingLot_b;

    @BeforeEach
    public void before(){
        System.out.println("before");

        List<ParkingSpace> parkingSpaceList = new ArrayList<>();
        parkingSpaceList.add(new ParkingSpace("s-01", "occupied"));
        parkingSpaceList.add(new ParkingSpace("s-02", "occupied"));
        parkingLot_a = new ParkingLot("p-01", 2, parkingSpaceList);

        parkingLot_b = new ParkingLot("p-02", 1, new ArrayList<>());
    }

    @Test
    public void shouldReturnFalseIfParkingLotIsNotFull(){

        Boolean res = a_parkingLot.isFull(parkingLot_b);
        System.out.println(res);
        assertEquals(res, false);
    }

    @Test
    public void shouldReturnTrueIfParkingLotIsFull(){

        Boolean res = a_parkingLot.isFull(parkingLot_a);
        System.out.println(res);
        assertEquals(res, true);
    }

}