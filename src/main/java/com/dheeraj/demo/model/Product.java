package com.dheeraj.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Product {
    private int prodId;
    private String prodNmme;
    private int price;

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
