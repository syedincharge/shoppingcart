package com.tcs.example.shoppingcart.service;


import com.tcs.example.shoppingcart.entity.Country;
import com.tcs.example.shoppingcart.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private  final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    public Country getCountry(int id){

        return countryRepository.findById(id);
    }

    public List<Country> getCountries(){

        return countryRepository.findAll();
    }

    public Country findByIdAndName(int id, String name){
        return countryRepository.findByIdAndName(id, name);
    }
}
