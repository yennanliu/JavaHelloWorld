package com.yen.TddPlayGround.ParkingLot.service.Impl;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import com.yen.TddPlayGround.ParkingLot.bean.ParkingSpace;
import com.yen.TddPlayGround.ParkingLot.repository.CarRepository;
import com.yen.TddPlayGround.ParkingLot.repository.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class A_ParkingLot_Test {

    @InjectMocks
    A_ParkingLot a_parkingLot;

    @Mock
    CarRepository carRepository;

    @Mock
    ParkingLotRepository parkingLotRepository;

    ParkingLot parkingLot_a;

    ParkingLot parkingLot_b;

    ParkingLot parkingLot_c;

    Car car_a;
    Car car_b;

    Car car_c;

    @BeforeEach
    public void before(){
        System.out.println("before");

        car_a = new Car("c-01");
        car_b = new Car("c-02");
        car_c = new Car("c-03");

        List<ParkingSpace> parkingSpaceList = new ArrayList<>();
        parkingSpaceList.add(new ParkingSpace(car_a.getId(), "occupied"));
        parkingSpaceList.add(new ParkingSpace(car_b.getId(), "occupied"));
        parkingLot_a = new ParkingLot("p-01", 2, parkingSpaceList);

        parkingLot_b = new ParkingLot("p-02", 1, new ArrayList<>());

        parkingLot_c = new ParkingLot("p-03", 0, new ArrayList<>());
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

    @Test
    public void shouldReturnTrueIfParkingLotIsNotFull(){

        // mock
        Mockito.when(carRepository.findById("c-01")).thenReturn(Optional.ofNullable(car_a));
        Mockito.when(parkingLotRepository.findById("p-02")).thenReturn(Optional.ofNullable(parkingLot_b));

        // run
        boolean res = a_parkingLot.park(car_a.getId(), parkingLot_b.getId());
        // verify
        assertEquals(res, true);
    }

    @Test
    public void shouldReturnFalseIfParkingLotIsFull(){

        // mock
        Mockito.when(carRepository.findById("c-01")).thenReturn(Optional.ofNullable(car_a));
        Mockito.when(parkingLotRepository.findById("p-01")).thenReturn(Optional.ofNullable(parkingLot_a));

        // run
        boolean res = a_parkingLot.park(car_a.getId(), parkingLot_a.getId());
        // verify
        assertEquals(res, false);
    }

    @Test
    public void shouldReturnTrueIfCarInParkingLot(){

        boolean res = a_parkingLot.leave(car_a, parkingLot_a);
        System.out.println(res);
        assertEquals(res, true);
    }

    @Test
    public void shouldReturnFalseIfNoCarInParkingLot(){

        boolean res = a_parkingLot.leave(car_a, parkingLot_c);
        System.out.println(res);
        assertEquals(res, false);
    }

    @Test
    public void shouldReturnParkingLotSize(){

        assertEquals(parkingLot_c.getSize(), 0);
        assertEquals(parkingLot_c.getFreeAmount(), 0);
    }

    @Test
    public void shouldUpdateParkingLotSize(){

        assertEquals(parkingLot_a.getFreeAmount(), 0);
        assertEquals(parkingLot_a.getSize(), 2);

        a_parkingLot.leave(car_a, parkingLot_a);
        assertEquals(parkingLot_a.getFreeAmount(), 1);

        a_parkingLot.leave(car_c, parkingLot_a);
        assertEquals(parkingLot_a.getFreeAmount(), 1);

        a_parkingLot.leave(car_b, parkingLot_a);
        assertEquals(parkingLot_a.getFreeAmount(), 2);
    }

}