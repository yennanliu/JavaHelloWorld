package com.yen.TddPlayGround.ParkingLot.repository;

import com.yen.TddPlayGround.ParkingLot.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
