package com.yen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yen.model.Product;

@RestController
public class ProductServiceController {private static Map<String, Product> productRepo = new HashMap<>();
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

    // Delete API
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted OK !", HttpStatus.OK);
    }

    // Put API
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated OK !", HttpStatus.OK);
    }

    // POST API
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created OK!", HttpStatus.CREATED);
    }

    // Get API
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
}
