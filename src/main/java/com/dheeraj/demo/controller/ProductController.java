package com.dheeraj.demo.controller;

import com.dheeraj.demo.model.Product;
import com.dheeraj.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin    // to allow the frontend app to access this app(server) without CORS error (cross-origin resource sharing)
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable int id){
        return service.getProductById(id);
    }
}
