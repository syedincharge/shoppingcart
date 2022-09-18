package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAll();
    Order findById(int id);
    List<Order> findOrderByCustomerId(int customerId);
    Order save(Order order);
    Order deleteById(int id);
}
