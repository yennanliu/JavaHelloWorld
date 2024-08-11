package com.yen.grpc.client;

import com.yen.grpc.GreetingServiceGrpc;
import com.yen.grpc.GreetingServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    private static int PORT = 7777;

    public static void main(String[] args) {

        System.out.println("GRPC client start ...");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", PORT)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceProto.GreetingRequest request = GreetingServiceProto.GreetingRequest.newBuilder()
                .setName("John Doe")
                .build();

        GreetingServiceProto.GreetingResponse response = stub.greet(request);

        System.out.println(response.getMessage());

        System.out.println("GRPC client shutdown ...");
        channel.shutdown();
    }

}