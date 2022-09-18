package com.tcs.example.shoppingcart.service;


import com.tcs.example.shoppingcart.entity.Order;
import com.tcs.example.shoppingcart.entity.OrderItem;
import com.tcs.example.shoppingcart.entity.ShoppingCartEntry;
import com.tcs.example.shoppingcart.exception.ShoppingCartEmptyException;
import com.tcs.example.shoppingcart.repository.OrderItemRepository;
import com.tcs.example.shoppingcart.repository.OrderRepository;
import com.tcs.example.shoppingcart.repository.ShoppingCartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.tcs.example.shoppingcart.entity.Order.saveOder;

@Service
public class OrderService {


    Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final ShoppingCartRepository shoppingCartRepository;

    private final OrderItemService orderItemService;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        OrderItemService orderItemService,
                        ShoppingCartRepository shoppingCartRepository) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
        this.orderItemRepository = orderItemRepository;
        this.shoppingCartRepository = shoppingCartRepository;

    }

    public Order getOrder(int id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrders(int customerId) {
        return orderRepository.findOrderByCustomerId(customerId);
    }

    @Transactional
    public Order deleteOrder(int orderId) {
        orderItemRepository.deleteAllByOrderId(orderId);
        return orderRepository.deleteById(orderId);
    }

    @Transactional
    public Order createOrder(Order order) throws ShoppingCartEmptyException {
        log.info("Order: " + order);

        List<ShoppingCartEntry> shoppingCartEntries = this.shoppingCartRepository.findByCustomerId(order.getCustomerId());

        log.info("Shopping cart :  " + shoppingCartEntries);

        if (shoppingCartEntries.size() == 0)
            throw new ShoppingCartEmptyException("You cannot create an Order because shopping cart is empty");

            saveOder = this.orderRepository.save(order);

            for (ShoppingCartEntry sce : shoppingCartEntries) {
                OrderItem oi = new OrderItem(sce, saveOder);

                oi.setId(this.orderItemService.getNextId());
                oi = this.orderItemRepository.save(oi);

                log.info("Order Item  : " + oi);
                this.shoppingCartRepository.delete(sce);
            }
            return order;
        }
    }

