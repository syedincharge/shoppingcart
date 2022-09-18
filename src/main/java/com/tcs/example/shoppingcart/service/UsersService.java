package com.tcs.example.shoppingcart.service;


import com.tcs.example.shoppingcart.entity.User;
import com.tcs.example.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUser(int id){
        return userRepository.findById(id);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
