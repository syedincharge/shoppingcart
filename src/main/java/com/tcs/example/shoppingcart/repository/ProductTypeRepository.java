package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    List<ProductType> findAll();
    ProductType findById(int id);
    ProductType save(ProductType productType);

}
