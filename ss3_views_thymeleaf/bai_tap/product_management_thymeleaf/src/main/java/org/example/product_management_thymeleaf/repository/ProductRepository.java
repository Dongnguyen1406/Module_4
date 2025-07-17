package org.example.product_management_thymeleaf.repository;

import org.example.product_management_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Computer", 2, 1200.0, "rat oke"));
        products.put(2, new Product(2, "Head Phone", 2, 1200.0, "rat oke"));
        products.put(3, new Product(3, "Smart Phone", 2, 1200.0, "rat oke"));
        products.put(4, new Product(4, "Laptop", 2, 1200.0, "rat oke"));
        products.put(5, new Product(5, "Wash Machine", 2, 1200.0, "rat oke"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
