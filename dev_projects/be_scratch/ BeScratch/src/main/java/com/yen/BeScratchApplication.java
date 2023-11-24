package com.yen;

import com.sun.net.httpserver.HttpServer;
import com.yen.repository.ProductRepository;
import com.yen.service.ProductService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// https://medium.com/consulner/framework-less-rest-api-in-java-dd22d4d642fa

public class BeScratchApplication {
    public static void main(String[] args) throws IOException {

        System.out.println("BeScratchApplication run ...");

        int serverPort = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        // context
        server.createContext("/hello", (exchange -> {
            String respText = "hello world !!!";
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        server.createContext("/hello2", (exchange -> {
            String respText = "hello world 2 !!!";
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            output.close();
            exchange.close();
        }));

        // TODO : do the rest for ProductController endpoint

//        RegistrationHandler registrationHandler =
//                new RegistrationHandler(ProductService.class, ProductRepository.class);
//        server.createContext("products", registrationHandler::handle);

        server.setExecutor(null); // create a default executor (?)
        server.start();
    }

}