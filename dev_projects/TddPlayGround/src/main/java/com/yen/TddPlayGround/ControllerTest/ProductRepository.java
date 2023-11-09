package com.yen.TddPlayGround.ControllerTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Product findByName(String name);
}
