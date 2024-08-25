package com.yen.grpc.server;

// import com.yen.service.GreetingServiceImpl;
import com.yen.grpc.service.CarRentalServiceImpl;
import com.yen.grpc.service.CarServiceImpl;
import com.yen.grpc.service.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import java.io.IOException;

public class GrpcServer {

  private static final int PORT = 7777;

  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println("GRPC server start ...");

    Server server =
        ServerBuilder.forPort(PORT)
            // TODO : check if necessary to cast
            .addService(new GreetingServiceImpl())
            .addService(new CarServiceImpl()) // NOTE !!! need to add service here
            .addService(new CarRentalServiceImpl())
            .addService(ProtoReflectionService.newInstance()) // Add this line to enable reflection
            .build();

    server.start();

    server.awaitTermination();
    System.out.println("GRPC server terminated ...");
  }
}
