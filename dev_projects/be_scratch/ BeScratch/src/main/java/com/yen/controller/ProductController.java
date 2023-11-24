package com.yen.controller;

// https://www.javachinna.com/jersey-rest-crud-api/

import com.yen.bean.Product;
import com.yen.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//@Slf4j
@Path("products")
public class ProductController {

    private ProductService productService;

    // constructor (?
    // NOTE !!! inject here // TODO : double check
    @Inject
    public ProductController(ProductService productService){

        this.productService = productService;
    }

    // GET
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductList(){

        return productService.listAll();
    }

    @GET
    @Path("{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam(value = "productId") Long productId){

        return productService.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @POST
    public String createProduct(Product product){

        productService.save(product);
        return product + " is added";
    }

    @PUT
    @Path("{productId}")
    public String updateProduct(
            @PathParam(value = "productId") Long productId,
            Product product){

        // TODO : check if can do below logic in service
        return productService.findById(productId).map( x -> {
            x.setName(product.getName());
            x.setPrice(product.getPrice());
            productService.update(x);
            return "product update OK";
        }).orElseThrow(() -> new RuntimeException("product update failed"));
    }

    @DELETE
    @Path("{productId}")
    public String deleteProduct(@PathParam(value = "productId") Long productId){
        return productService.findById(productId).map(x -> {
            productService.delete(productId);
            return "delete product OK";
        }).orElseThrow(() -> new RuntimeException("delete product failed"));
    }

}
