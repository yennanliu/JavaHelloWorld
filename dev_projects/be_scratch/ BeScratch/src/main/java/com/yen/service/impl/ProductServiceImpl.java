package com.yen.service.impl;

// https://www.javachinna.com/jersey-rest-crud-api/

import com.yen.bean.Product;
import com.yen.repository.ProductRepository;
import com.yen.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

}
