package com.yen.grpc.client;

import com.yen.grpc.CarServiceGrpc;
import com.yen.grpc.CarServiceProto;
import com.yen.grpc.GreetingServiceGrpc;
import com.yen.grpc.GreetingServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  private static final int PORT = 7777;

  public static void main(String[] args) {

    System.out.println("GRPC client start ...");

    ManagedChannel channel =
        ManagedChannelBuilder.forAddress("localhost", PORT).usePlaintext().build();

    System.out.println("channel = " + channel);

    /** V1 : call GreetingServiceGrpc */
    System.out.println("---------- GreetingServiceGrpc ----------");
    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);

    System.out.println("stub = " + stub);

    GreetingServiceProto.GreetingRequest request =
        GreetingServiceProto.GreetingRequest.newBuilder()
            // .setName("John Doe")
            .setName("kkkk")
            .build();

    GreetingServiceProto.GreetingResponse response = stub.greet(request);

    System.out.println("response = " + response);
    System.out.println(response.getMessage());

    /** V1 : call CarServiceGrpc */
    System.out.println("---------- CarServiceGrpc ----------");

//    CarServiceGrpc.CarServiceBlockingStub stub2 = CarServiceGrpc.newBlockingStub(channel);
//
//    CarServiceProto.DriveRequest request2 =
//        CarServiceProto.DriveRequest.newBuilder().setName("lexus").build();
//
//    CarServiceProto.DriveResponse response2 = stub2.drive(request2);
//    System.out.println(response2.getSpeed());

    System.out.println("GRPC client shutdown ...");
    channel.shutdown();
  }

}
