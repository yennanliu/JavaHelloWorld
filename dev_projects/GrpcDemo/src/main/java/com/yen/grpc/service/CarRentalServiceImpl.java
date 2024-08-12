package com.yen.grpc.service;

import com.yen.grpc.CarRentalProto;
import com.yen.grpc.CarRentalServiceGrpc;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalServiceImpl extends CarRentalServiceGrpc.CarRentalServiceImplBase {

  private final ConcurrentHashMap<String, CarRentalProto.Car> carDatabase =
      new ConcurrentHashMap<>();

  public CarRentalServiceImpl() {
    // Initialize the car database with some sample data
    initializeCarDatabase();
  }

  private void initializeCarDatabase() {
    carDatabase.put(
        "1",
        CarRentalProto.Car.newBuilder()
            .setId("1")
            .setMake("Toyota")
            .setModel("Corolla")
            .setYear(2020)
            .setIsRented(false)
            .build());
    carDatabase.put(
        "2",
        CarRentalProto.Car.newBuilder()
            .setId("2")
            .setMake("Ford")
            .setModel("Focus")
            .setYear(2018)
            .setIsRented(false)
            .build());
    carDatabase.put(
        "3",
        CarRentalProto.Car.newBuilder()
            .setId("3")
            .setMake("Honda")
            .setModel("Civic")
            .setYear(2019)
            .setIsRented(false)
            .build());
  }

  @Override
  public void listAvailableCars(
      CarRentalProto.Empty request,
      StreamObserver<CarRentalProto.CarListResponse> responseObserver) {
    List<CarRentalProto.Car> availableCars = new ArrayList<>();
    for (CarRentalProto.Car car : carDatabase.values()) {
      if (!car.getIsRented()) {
        availableCars.add(car);
      }
    }
    CarRentalProto.CarListResponse response =
        CarRentalProto.CarListResponse.newBuilder().addAllCars(availableCars).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void rentCar(
      CarRentalProto.RentCarRequest request,
      StreamObserver<CarRentalProto.RentCarResponse> responseObserver) {
    CarRentalProto.Car car = carDatabase.get(request.getCarId());
    if (car != null && !car.getIsRented()) {
      car = car.toBuilder().setIsRented(true).build();
      carDatabase.put(car.getId(), car);
      CarRentalProto.RentCarResponse response =
          CarRentalProto.RentCarResponse.newBuilder()
              .setMessage("Car rented successfully by " + request.getRenterName())
              .build();
      responseObserver.onNext(response);
    } else {
      CarRentalProto.RentCarResponse response =
          CarRentalProto.RentCarResponse.newBuilder().setMessage("Car not available").build();
      responseObserver.onNext(response);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void returnCar(
      CarRentalProto.ReturnCarRequest request,
      StreamObserver<CarRentalProto.ReturnCarResponse> responseObserver) {
    CarRentalProto.Car car = carDatabase.get(request.getCarId());
    if (car != null && car.getIsRented()) {
      car = car.toBuilder().setIsRented(false).build();
      carDatabase.put(car.getId(), car);
      CarRentalProto.ReturnCarResponse response =
          CarRentalProto.ReturnCarResponse.newBuilder()
              .setMessage("Car returned successfully")
              .build();
      responseObserver.onNext(response);
    } else {
      CarRentalProto.ReturnCarResponse response =
          CarRentalProto.ReturnCarResponse.newBuilder()
              .setMessage("Car not found or not rented")
              .build();
      responseObserver.onNext(response);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void getCarDetails(
      CarRentalProto.CarDetailsRequest request,
      StreamObserver<CarRentalProto.CarDetailsResponse> responseObserver) {
    CarRentalProto.Car car = carDatabase.get(request.getCarId());
    if (car != null) {
      CarRentalProto.CarDetailsResponse response =
          CarRentalProto.CarDetailsResponse.newBuilder().setCar(car).build();
      responseObserver.onNext(response);
    } else {
      responseObserver.onNext(CarRentalProto.CarDetailsResponse.newBuilder().build());
    }
    responseObserver.onCompleted();
  }
}
