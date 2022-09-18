package com.tcs.example.shoppingcart.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {

    @Id
    private int id;

    private String sku;
    private String name;
    private String description;
    @Column(name="product_type")
    private int productType;
    private float price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
        Product product = (Product) o;
        return id == product.id && productType == product.productType && Float.compare(product.price, price) == 0 && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku, name, description, productType, price);
    }
}
