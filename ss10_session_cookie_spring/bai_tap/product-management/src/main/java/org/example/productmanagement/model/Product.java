package org.example.productmanagement.model;

import javax.persistence.Entity;

@Entity
public class Product {
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
     
}
