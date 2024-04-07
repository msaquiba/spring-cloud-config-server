package com.inventorymgmt.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stock_unique_no")
    private int stockUniqueNo;
    @Column(name="product_nm")
    private String productName;
    @Column(name="category")
    private String category;
    @Column(name="model_no")
    private String modelNo;
    @Column(name="quantity")
    private int quantity;
    @Column(name="price")
    private double price;
}
