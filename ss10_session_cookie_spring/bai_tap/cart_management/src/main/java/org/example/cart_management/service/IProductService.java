package org.example.cart_management.service;

import org.example.cart_management.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
