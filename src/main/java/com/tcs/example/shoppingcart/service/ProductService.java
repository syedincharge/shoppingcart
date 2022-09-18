package com.tcs.example.shoppingcart.service;

import com.tcs.example.shoppingcart.entity.Country;
import com.tcs.example.shoppingcart.entity.Product;
import com.tcs.example.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(int id){

        return productRepository.findById(id);
    }

    public List<Product> getProducts(){

        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProductsByType(int prodType){
        return  productRepository.findByProductType(prodType);
    }
}
