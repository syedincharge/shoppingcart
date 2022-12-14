package com.tcs.example.shoppingcart.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCartEntry {
   @Id
   private  int id;

   @Column(name = "product_id")
    private int productId;

   @Column(name = "customer_id")
    private  int customerId;

   @Column(name = "quantity")
    private int quantity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
        ShoppingCartEntry that = (ShoppingCartEntry) o;
        return id == that.id && productId == that.productId && customerId == that.customerId && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, customerId, quantity);
    }
}
