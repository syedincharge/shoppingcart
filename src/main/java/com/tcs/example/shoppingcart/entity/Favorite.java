package com.tcs.example.shoppingcart.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "favorites")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Favorite {
    @Id
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "product_id")
    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
        Favorite favorite = (Favorite) o;
        return id == favorite.id && userId == favorite.userId && productId == favorite.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId);
    }
}
