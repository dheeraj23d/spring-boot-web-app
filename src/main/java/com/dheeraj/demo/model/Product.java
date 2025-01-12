package com.dheeraj.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.EmbeddableInstantiator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {
    @Id
    private int prodId;
    private String prodNmme;
    private int price;

    public Product() {
        this.prodId = 0;
        this.prodNmme = "";
        this.price = 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodNmme='" + prodNmme + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(int prodId, String prodNmme, int price) {
        this.prodId = prodId;
        this.prodNmme = prodNmme;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdNmme() {
        return prodNmme;
    }

    public void setProdNmme(String prodNmme) {
        this.prodNmme = prodNmme;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
