package com.yen.grpc.server;

//import com.yen.service.GreetingServiceImpl;
import com.yen.grpc.service.GreetingServiceImpl;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {

//  public static void main(String[] args) {
//    System.out.println("GRPC Hello world!");
//  }

  private static final int PORT = 7777;

  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println("GRPC server start ...");

    Server server = ServerBuilder.forPort(PORT)
            // TODO : check if necessary to cast
            .addService(new GreetingServiceImpl())
            .build();

    server.start();

    server.awaitTermination();
    System.out.println("GRPC server terminated ...");
  }


}
