package com.yen.service;

// https://www.javachinna.com/jersey-rest-crud-api/

import com.yen.bean.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save(Product product);

    public Product update(Product product);

    public void delete(Long id);

    public Optional<Product> findById(Long id);

    public List<Product> listAll();
}
