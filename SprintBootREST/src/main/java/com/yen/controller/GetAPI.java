package com.yen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yen.model.Product;

@RestController
public class GetAPI {
    private static Map<String, Product> productRepo = new HashMap<>();
    // TODO : check what does "static" mean below
    static {
        // put product 1
        Product milk = new Product();
        milk.setId("1");
        milk.setName("milk");
        productRepo.put(milk.getId(), milk);

        // put product 2
        Product cheeze = new Product();
        cheeze.setId("2");
        cheeze.setName("cheeze");
        productRepo.put(cheeze.getId(), cheeze);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
}
