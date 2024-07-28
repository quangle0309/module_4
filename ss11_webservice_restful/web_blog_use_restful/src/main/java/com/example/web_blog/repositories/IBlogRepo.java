package com.example.web_blog.repositories;

import com.example.web_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog, Long> {

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable);

    List<Blog> findAllByCategoryId(Long categoryId);
}
