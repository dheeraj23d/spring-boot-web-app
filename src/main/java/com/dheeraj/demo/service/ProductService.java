package com.dheeraj.demo.service;

import com.dheeraj.demo.model.Product;
import com.dheeraj.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);  // this null check is handled in ProductController
    }

    public Product addProduct(Product p, MultipartFile imgFile) throws IOException {
        p.setImageName(imgFile.getOriginalFilename());
        p.setImageType(imgFile.getContentType());
        p.setImageFile(imgFile.getBytes());
        return repo.save(p);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException{
        product.setImageFile(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}

