package com.tcs.example.shoppingcart.repository;

import com.tcs.example.shoppingcart.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findById(int userId);

    Favorite save(Favorite favorite);

}
