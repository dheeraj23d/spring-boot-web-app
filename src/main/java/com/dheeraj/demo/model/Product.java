package com.dheeraj.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")  // convert to this format while storing in db
    @Column(name = "releasedate")
    private Date releasedate;
    private int quantity;
    private boolean available;
}
