package org.example.product_management_thymeleaf.service;

import org.example.product_management_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
    
    List<Product> searchByName(String name);
}
