package com.tcs.example.shoppingcart.entity;

import javax.persistence.Id;
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
@Table(name = "product_types")
public class ProductType {
     @Id
     private  int  id;
     @Column(name = "type_name")
     private String typeName;


     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(this)) return false;
          ProductType that = (ProductType) o;
          return id == that.id && Objects.equals(typeName, that.typeName);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, typeName);
     }
}
