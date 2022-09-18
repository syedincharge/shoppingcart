package com.tcs.example.shoppingcart.service;

import com.tcs.example.shoppingcart.entity.ProductType;
import com.tcs.example.shoppingcart.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;


    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }


    public ProductType getProductType(int id){

        return this.productTypeRepository.findById(id);
    }

    public List<ProductType> getProductTypes(){

        return this.productTypeRepository.findAll();
    }


    public ProductType addProductType(ProductType productType){

        return this.productTypeRepository.save(productType);
    }
}
