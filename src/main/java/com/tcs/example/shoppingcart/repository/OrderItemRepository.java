package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAll();
    List<OrderItem> findAllByOrderId(int orderId);
    OrderItem findById(int id);
    OrderItem save(OrderItem orderItem);
    void deleteAllByOrderId(int orderId);

}
