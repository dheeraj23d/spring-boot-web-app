package com.dheeraj.demo.service;

import com.dheeraj.demo.model.Product;
import com.dheeraj.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product p){
        repo.save(p);
    }

    public void updateProduct(Product p) {
        repo.save(p);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}

