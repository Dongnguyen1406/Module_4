package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
//    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> searchByTitle(String keyword, Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    boolean update(Blog blog);
    boolean delete(Integer id);
    Page<Blog> searchBlogs(String keyword, Integer categoryId, Pageable pageable);
}
