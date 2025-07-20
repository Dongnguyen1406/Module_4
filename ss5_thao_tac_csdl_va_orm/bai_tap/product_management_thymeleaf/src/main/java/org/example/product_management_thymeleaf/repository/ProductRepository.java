package org.example.product_management_thymeleaf.repository;

import org.example.product_management_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT p FROM Product p";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();

        if (product.getId() == 0) {
            BaseRepository.entityManager.persist(product);
        } else {
            Product existing = BaseRepository.entityManager.find(Product.class, product.getId());
            if (existing != null) {
                existing.setName(product.getName());
                existing.setQuantity(product.getQuantity());
                existing.setPrice(product.getPrice());
                existing.setDescription(product.getDescription());
                BaseRepository.entityManager.merge(existing);
            }
        }

        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();

        Product existing = BaseRepository.entityManager.find(Product.class, id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            existing.setDescription(product.getDescription());
            BaseRepository.entityManager.merge(existing);
        }

        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();

        Product product = BaseRepository.entityManager.find(Product.class, id);
        if (product != null) {
            BaseRepository.entityManager.remove(product);
        }

        transaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        String queryStr = "SELECT p FROM Product p WHERE LOWER(p.name) LIKE :name";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        return query.getResultList();
    }
}
