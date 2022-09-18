package com.tcs.example.shoppingcart.service;


import com.tcs.example.shoppingcart.entity.OrderItem;
import com.tcs.example.shoppingcart.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderItemService {


    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getOrderItems(int orderId) {
        return orderItemRepository.findAllByOrderId(orderId);
    }

    public OrderItem getOrderItem(int id) {
        return orderItemRepository.findById(id);
    }

    public int getNextId() {
        List<OrderItem> items = this.orderItemRepository.findAll();

        if (items != null) {
            Collections.sort(items);
            if (items.size() > 0) {
                OrderItem oi = items.get(items.size() - 1);
                return oi.getId() + 1;
            } else {
                return 1;
            }
        } else return 1;
    }
}
