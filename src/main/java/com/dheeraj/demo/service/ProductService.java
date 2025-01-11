package com.dheeraj.demo.service;

import com.dheeraj.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(101, "Phone", 25000),
            new Product(102,"Camera",50000),
            new Product(103,"Headset",5000)
    );

    public List<Product> getProducts(){
        return products;
    }
}

