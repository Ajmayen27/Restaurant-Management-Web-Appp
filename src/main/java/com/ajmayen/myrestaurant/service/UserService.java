package com.ajmayen.myrestaurant.service;

import com.ajmayen.myrestaurant.model.RestaurantUser;
import com.ajmayen.myrestaurant.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RestaurantUser registerUser(RestaurantUser restaurantUser) {

        restaurantUser.setRestaurantName(restaurantUser.getRestaurantName());
        restaurantUser.setRestaurantAddress(restaurantUser.getRestaurantAddress());
        restaurantUser.setOwnerPhoneNumber(restaurantUser.getOwnerPhoneNumber());
        restaurantUser.setRestaurantEmailAddress(restaurantUser.getRestaurantAddress());
        restaurantUser.setPassword(restaurantUser.getPassword());
        return userRepository.save(restaurantUser);
       
    }
}
