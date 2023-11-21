package com.yen.TddPlayGround.Bank.controller;

import com.yen.TddPlayGround.Bank.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Spring Boot!");
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> sayHello2() {
        String greeting = exampleService.getGreeting();
        return ResponseEntity.ok(greeting);
    }

}
