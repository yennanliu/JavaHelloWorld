package com.yen.grpc.service;

import com.yen.grpc.CarServiceGrpc;
import com.yen.grpc.CarServiceProto;
import io.grpc.stub.StreamObserver;
import java.util.Random;

public class CarServiceImpl extends CarServiceGrpc.CarServiceImplBase {

  @Override
  public void drive(
      CarServiceProto.DriveRequest request,
      StreamObserver<CarServiceProto.DriveResponse> responseObserver) {

    // super.drive(request, responseObserver);
    String name = request.getName();

    // String msg = "----> car start driving ... " + name;
    Random random = new Random();
    Integer min = 1;
    Integer max = 100;
    Integer speed = random.nextInt(max - min) + min;

    CarServiceProto.DriveResponse response =
        CarServiceProto.DriveResponse.newBuilder().setSpeed(speed).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
