package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(Integer id);
    boolean update(Category category);
    boolean delete(Integer id);
}
