package com.tcs.example.shoppingcart.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @ManyToMany
    @JoinColumn(name = "oder_id")
    public static Order saveOder;
    @Id
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "credit_card_last_four")
    private String lastFour;

    @Column(name = "customer_id ")
    private  int customerId;

    @Column(name = "order_amount ")
     private float orderAmount;

     private float tax;
     private float shipping;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
        Order order = (Order) o;
        return id == order.id && customerId == order.customerId && Float.compare(order.orderAmount, orderAmount) == 0 && Float.compare(order.tax, tax) == 0 && Float.compare(order.shipping, shipping) == 0 && Objects.equals(orderDate, order.orderDate) && Objects.equals(lastFour, order.lastFour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, lastFour, customerId, orderAmount, tax, shipping);
    }
}
