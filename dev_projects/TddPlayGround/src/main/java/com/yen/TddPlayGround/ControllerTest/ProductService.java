package com.yen.TddPlayGround.ControllerTest;

// https://github.com/sashinpivotal/spring-boot-tdd/blob/main/src/main/java/io/pivotal/workshop/CarService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    private ProductRepository productRepository;


    // TODO : verify pros & cons on below :
    // Autowired or crrate a constructor with repository
//    @Autowired
//    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(String name){

        Product product = productRepository.findByName(name);
        if (product == null){
            throw new ProductNotFoundException();
        }

        product.setPrice(product.getPrice()+1);
        return product;
    }

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

}
