package com.yen.grpc.service;

import com.yen.grpc.GreetingServiceGrpc;
import com.yen.grpc.GreetingServiceProto;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
  @Override
  public void greet(
      GreetingServiceProto.GreetingRequest request,
      StreamObserver<GreetingServiceProto.GreetingResponse> responseObserver) {
    String name = request.getName();
    String message = "Hello, " + name + "!";

    GreetingServiceProto.GreetingResponse response =
        GreetingServiceProto.GreetingResponse.newBuilder().setMessage(message).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
