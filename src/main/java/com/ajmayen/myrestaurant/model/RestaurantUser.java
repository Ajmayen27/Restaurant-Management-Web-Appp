package com.ajmayen.myrestaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class RestaurantUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String restaurantName;

    @Column( nullable = false)
    private String restaurantOwnerName;

    @Column(unique = true, nullable = false)
    private String OwnerPhoneNumber;

    @Column( nullable = false)
    private String restaurantEmailAddress;

    @Column( nullable = false)
    private String restaurantAddress;

    @Column( nullable = false)
    private String password;
}
