package com.tcs.example.shoppingcart.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    @Id
    private int id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return getId() == country.getId() && Objects.equals(getName(), country.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
