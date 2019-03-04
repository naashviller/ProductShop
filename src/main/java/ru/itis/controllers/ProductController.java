package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.services.ProductService;

@Controller
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "products";
    }



}
