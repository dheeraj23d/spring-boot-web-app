package com.dheeraj.demo.service;

import com.dheeraj.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Phone", 25000),
            new Product(102,"Camera",50000),
            new Product(103,"Headset",5000)
    ));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getProdId()==id)
                .findFirst().orElse(new Product(0,"no such product",0));
    }
    public void addProduct(Product p){
        products.add(p);
    }

    public void updateProduct(Product p) {
        int prodInd = -1;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==p.getProdId()){
                prodInd = i;
            }
        }
        if(prodInd!=-1){
            products.set(prodInd, p);
        }
    }

    public void deleteProduct(int id) {
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==id){
                products.remove(i);
            }
        }
    }
}

