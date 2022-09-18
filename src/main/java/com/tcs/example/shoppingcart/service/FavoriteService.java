package com.tcs.example.shoppingcart.service;

import com.tcs.example.shoppingcart.entity.Favorite;
import com.tcs.example.shoppingcart.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    public List<Favorite> getFavorites(int userId){
        return this.favoriteRepository.findById(userId);
    }
    public Favorite addFavorite(Favorite favorite){
        return  this.favoriteRepository.save(favorite);
    }
}
