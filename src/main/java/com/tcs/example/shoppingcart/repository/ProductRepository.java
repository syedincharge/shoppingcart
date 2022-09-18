package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String productName);
    Product findById(int id);
    List<Product> findAll();
    List<Product> findByProductType(int prodTypeId);
    Product save(Product product);
}
