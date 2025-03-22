package com.ajmayen.myrestaurant.repository;

import com.ajmayen.myrestaurant.model.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<RestaurantUser, Long> {

    Optional<RestaurantUser> findByRestaurantEmailAddress(String emailAddress );


}
