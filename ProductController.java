package com.yourcompany.ecommerce.controller;

import com.yourcompany.ecommerce.model.Product;
import com.yourcompany.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model) {
        // Sample data
        Product product1 = new Product("Laptop", "Powerful laptop with high performance", 1200.0);
        Product product2 = new Product("Smartphone", "Latest smartphone with advanced features", 800.0);
        Product product3 = new Product("Headphones", "Wireless headphones with noise cancellation", 150.0);

        productRepository.saveAll(List.of(product1, product2, product3));

        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }
}
