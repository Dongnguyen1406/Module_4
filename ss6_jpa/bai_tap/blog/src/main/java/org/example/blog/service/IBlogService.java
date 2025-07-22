package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void delete(Integer id);
}
