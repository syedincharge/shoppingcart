package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.ShoppingCartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntry, Long> {

    List<ShoppingCartEntry> findAll();
    ShoppingCartEntry findById(int id);
    List<ShoppingCartEntry> findByProductId(int id);
    List<ShoppingCartEntry> findByCustomerId(int id);
    ShoppingCartEntry findByCustomerIdAndProductId(int customerId, int productId);
    ShoppingCartEntry save(ShoppingCartEntry shoppingCartEntry);
    ShoppingCartEntry deleteById(int id);
    void delete(ShoppingCartEntry shoppingCartEntry);
}
