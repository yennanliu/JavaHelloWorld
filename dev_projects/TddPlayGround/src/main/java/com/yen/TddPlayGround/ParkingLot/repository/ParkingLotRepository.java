package com.yen.TddPlayGround.ParkingLot.repository;

import com.yen.TddPlayGround.ParkingLot.bean.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : redo below without using spring boot
public interface ParkingLotRepository extends JpaRepository<ParkingLot, String> {
}
