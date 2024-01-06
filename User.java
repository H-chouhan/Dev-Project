package com.yourcompany.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // Other user-related fields like preferences, order history, etc.

    // Getters and setters

    // Sample data
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
