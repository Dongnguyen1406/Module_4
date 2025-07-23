package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;
import org.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        if (category.getIdCategory() == null || categoryRepository.existsById(category.getIdCategory())) {
            categoryRepository.save(category);
        } else {
            throw new IllegalArgumentException("không thể cập nhập với id " + category.getIdCategory());
        }
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Category category) {
        if (category.getIdCategory() == null || categoryRepository.existsById(category.getIdCategory())) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Category category = findById(id);
        if (category != null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
