package com.yen.TddPlayGround.ControllerTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// https://github.com/sashinpivotal/spring-boot-tdd/blob/main/src/main/java/io/pivotal/workshop/CarController.java


//@Controller
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired // TODO : check is necessary ?
    public ProductController(ProductService productService) {

        this.productService = productService;
    }


    @GetMapping("/name")
    public Product getProduct(){

        Product product = productService.getProduct("iphone");
        product.setPrice(100);
        //return new Product("iphone",100);
        return product;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addProduct(Product product){

        // some code

        // TODO : double check below
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(product.getName())
                .toUri();

        System.out.println("uri = " + uri);
        return ResponseEntity.created(uri).build();
    }

}
