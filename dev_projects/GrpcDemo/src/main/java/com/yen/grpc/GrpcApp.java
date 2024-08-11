package com.yen.grpc;

//import com.yen.service.GreetingServiceImpl;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcApp {

//  public static void main(String[] args) {
//    System.out.println("GRPC Hello world!");
//  }

  private static int PORT = 500051;

  public static void main(String[] args) throws IOException, InterruptedException {

//    Server server = ServerBuilder.forPort(PORT)
//            // TODO : check if necessary to cast
//            .addService((BindableService) new GreetingServiceImpl())
//            .build();
//
//    System.out.println("Starting GRPC server...");
//    server.start();
//    System.out.println("GRPC Server started!");
//
//    server.awaitTermination();
  }


}
