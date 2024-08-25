package com.yen.grpc.client;

import com.yen.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  private static final int PORT = 7777;

  public static void main(String[] args) {

    System.out.println("GRPC client start ...");

    ManagedChannel channel =
        ManagedChannelBuilder.forAddress("localhost", PORT).usePlaintext().build();

    // System.out.println("channel = " + channel);

    /** V1 : call GreetingServiceGrpc */
    System.out.println("---------- GreetingServiceGrpc ----------");
    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);

    // System.out.println("stub = " + stub);

    GreetingServiceProto.GreetingRequest request =
        GreetingServiceProto.GreetingRequest.newBuilder()
            // .setName("John Doe")
            .setName("kkkk")
            .build();

    GreetingServiceProto.GreetingResponse response = stub.greet(request);

    // System.out.println("response = " + response);
    System.out.println(response.getMessage());

    /** V2 : call CarServiceGrpc */
    System.out.println("---------- CarServiceGrpc ----------");

    CarServiceGrpc.CarServiceBlockingStub stub2 = CarServiceGrpc.newBlockingStub(channel);

    CarServiceProto.DriveRequest request2 =
        CarServiceProto.DriveRequest.newBuilder().setName("lexus").build();

    CarServiceProto.DriveResponse response2 = stub2.drive(request2);
    System.out.println(response2.getSpeed());

    /** V3 : call CarRentalServiceGrpc */
    System.out.println("---------- CarRentalServiceGrpc ----------");

    CarRentalServiceGrpc.CarRentalServiceBlockingStub stub3 =
        CarRentalServiceGrpc.newBlockingStub(channel);

    // List available cars
    CarRentalProto.CarListResponse availableCars =
        stub3.listAvailableCars(CarRentalProto.Empty.newBuilder().build());
    System.out.println("Available cars:");
    for (CarRentalProto.Car car : availableCars.getCarsList()) {
      System.out.println(car.getId() + ": " + car.getMake() + " " + car.getModel());
    }

    // Rent a car
    CarRentalProto.RentCarResponse rentCarResponse =
        stub3.rentCar(
            CarRentalProto.RentCarRequest.newBuilder()
                .setCarId("1")
                .setRenterName("John Doe")
                .build());
    System.out.println(rentCarResponse.getMessage());

    // Get car details
    CarRentalProto.CarDetailsResponse carDetails =
        stub3.getCarDetails(CarRentalProto.CarDetailsRequest.newBuilder().setCarId("1").build());
    System.out.println(
        "Car Details: "
            + carDetails.getCar().getMake()
            + " "
            + carDetails.getCar().getModel()
            + ", Rented: "
            + carDetails.getCar().getIsRented());

    // Return the car
    CarRentalProto.ReturnCarResponse returnCarResponse =
        stub3.returnCar(CarRentalProto.ReturnCarRequest.newBuilder().setCarId("1").build());
    System.out.println(returnCarResponse.getMessage());

    System.out.println("GRPC client shutdown ...");
    channel.shutdown();
  }
}
