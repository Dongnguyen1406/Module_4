package org.example.blog.repository;

import org.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    
    @Query("SELECT b FROM Blog b WHERE (b.category.idCategory = :categoryId OR :categoryId = 0) AND (b.title LIKE CONCAT('%', :keyword, '%'))")
    Page<Blog> searchBlogs(@Param("keyword") String keyword,
                           @Param("categoryId") Integer idCategory,
                           Pageable pageable);

//    @Query("SELECT b FROM Blog b WHERE b.isDeleted = false")
//    Page<Blog> findAllNotDeleted(Pageable pageable);
}

