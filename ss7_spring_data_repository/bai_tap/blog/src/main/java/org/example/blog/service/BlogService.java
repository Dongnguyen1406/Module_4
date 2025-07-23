package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public List<Blog> findAll() {
//        return blogRepository.findAll();
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByTitle(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }


    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null || blogRepository.existsById(blog.getId())) {
            blogRepository.save(blog);
        } else {
            throw new IllegalArgumentException("không thể cập nhập với id " + blog.getId());
        }
    }

    @Override
    public boolean update(Blog blog) {
        if (blog.getId() == null || blogRepository.existsById(blog.getId())) {
            blogRepository.save(blog);
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(Integer id) {
        Blog blog = findById(id);
        if (blog != null) {
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Blog> searchBlogs(String keyword, Integer categoryId, Pageable pageable) {
        return blogRepository.searchBlogs(keyword, categoryId, pageable);
    }
}
