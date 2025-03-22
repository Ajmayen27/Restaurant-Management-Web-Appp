package com.ajmayen.myrestaurant.service;

import com.ajmayen.myrestaurant.model.RestaurantUser;
import com.ajmayen.myrestaurant.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RestaurantUser registerUser(RestaurantUser restaurantUser) {
        return userRepository.save(restaurantUser);

    }

    public RestaurantUser loggedInUser(String restaurantEmailAddress, String password) {

        Optional<RestaurantUser> restaurantUser = userRepository.findByRestaurantEmailAddress(restaurantEmailAddress);

        if(restaurantUser.isPresent()){
            RestaurantUser restaurantUser1 = restaurantUser.get();
            if(restaurantUser1.getPassword().equals(password)){
                return restaurantUser1;
            }
        }
        return null;
    }


    public RestaurantUser loginUser(String restaurantEmailAddress, String password) {
        return loggedInUser(restaurantEmailAddress,password);
    }





}
