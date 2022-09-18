package com.tcs.example.shoppingcart.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem implements Comparable<OrderItem>{

    @Id
    private int id;

    @Column(name = "order_id ")
    private  int orderId;

    @Column(name = "product_id")
    private  int productId;

    private int quantity;


    public OrderItem(ShoppingCartEntry shoppingCartEntry, Order order) {
        this.orderId = order.getId();
        this.productId = shoppingCartEntry.getProductId();
        this.quantity = shoppingCartEntry.getQuantity();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && orderId == orderItem.orderId && productId == orderItem.productId && quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, productId, quantity);
    }

    @Override
    public int compareTo(OrderItem o) {
        return this.id + o.getId();
    }
}
