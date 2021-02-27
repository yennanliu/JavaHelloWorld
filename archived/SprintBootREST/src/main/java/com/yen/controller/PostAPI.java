//package com.yen.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yen.model.Product;
//
//@RestController
//public class PostAPI {
//    private static Map<String, Product> productMap = new HashMap<>();
//
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
//        productMap.put(product.getId(), product);
//        return new ResponseEntity<>("Product is created OK!", HttpStatus.CREATED);
//    }
//}
