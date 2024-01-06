package com.yourcompany.ecommerce.controller;

import com.yourcompany.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model, Principal principal) {
        // Sample data
        User sampleUser = new User("john_doe", "password123");
        userRepository.save(sampleUser);

        String username = principal.getName();
        model.addAttribute("username", username);
        return "user/profile";
    }
}
