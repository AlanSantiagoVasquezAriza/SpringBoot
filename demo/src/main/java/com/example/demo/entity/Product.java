package com.example.demo.entity;

// Imports
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
        private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = true)
    private  String imageUrl;
}
