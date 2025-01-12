package com.dheeraj.demo.controller;

import com.dheeraj.demo.model.Product;
import com.dheeraj.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }
}
