package com.tcs.example.shoppingcart.repository;


import com.tcs.example.shoppingcart.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByName(String countryName);

    Country findById(int id);

    Country findByIdAndName(int id, String name);

    List<Country> findAll();

}
