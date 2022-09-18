package com.tcs.example.shoppingcart.service;


import com.tcs.example.shoppingcart.entity.ShoppingCartEntry;
import com.tcs.example.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartEntryService {

    private ShoppingCartRepository shoppingCartRepository;

   @Autowired
    public ShoppingCartEntryService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCartEntry getShoppingCartEntry(int id){
        return this.shoppingCartRepository.findById(id);
       }

    public List<ShoppingCartEntry> getCustomerShoppingCart(int customerId){
        return  shoppingCartRepository.findByCustomerId(customerId);
       }

    public List<ShoppingCartEntry>  getProductEntry(int productId){
       return  shoppingCartRepository.findByProductId(productId);
      }

    public ShoppingCartEntry addToCart(ShoppingCartEntry shoppingCartEntry){
       return shoppingCartRepository.save(shoppingCartEntry);
    }

    public ShoppingCartEntry getProductEntryByCustomerId(int customerId, int productId){
        return this.shoppingCartRepository.findByCustomerIdAndProductId(customerId, productId);
    }

}
