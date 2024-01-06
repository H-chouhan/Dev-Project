package com.yourcompany.ecommerce.service;

import com.yourcompany.ecommerce.model.Product;
import com.yourcompany.ecommerce.model.User;
import com.yourcompany.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    public List<Product> getRecommendedProducts(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return generateRecommendationsBasedOnUserBehavior(user);
        }

        return Collections.emptyList();
    }

    private List<Product> generateRecommendationsBasedOnUserBehavior(User user) {
        // Sample data
        Product recommendedProduct1 = new Product("Smartwatch", "Fitness tracker with smart features", 100.0);
        Product recommendedProduct2 = new Product("Camera", "High-quality digital camera for photography enthusiasts", 500.0);

        return List.of(recommendedProduct1, recommendedProduct2);
    }
}
