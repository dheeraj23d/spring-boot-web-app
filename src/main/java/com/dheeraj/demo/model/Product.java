package com.dheeraj.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // to auto assign the product ids
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    //handled by new UI-3
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")  // convert to this format while storing in db
    //@Column(name = "releaseDate")
    private Date releaseDate;
    private int stockQuantity;
    private boolean productAvailable;

    private String imageName;
    private String imageType;
    @Lob  // large object
    private byte[] imageFile;
}
