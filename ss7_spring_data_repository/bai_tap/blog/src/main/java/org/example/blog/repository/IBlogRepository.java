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

    @Query("select b from Blog b where " +  // thêm dấu cách sau where
            "(:keyword is null or lower(b.title) like lower(concat('%', :keyword, '%'))) and " +
            "(:categoryId is null or b.category.idCategory = :categoryId)")
        // bỏ dấu cách thừa
    Page<Blog> searchBlogs(@Param("keyword") String keyword,
                           @Param("categoryId") Integer categoryId,
                           Pageable pageable);

}
