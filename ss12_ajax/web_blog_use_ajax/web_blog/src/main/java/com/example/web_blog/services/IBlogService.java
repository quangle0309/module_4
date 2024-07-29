package com.example.web_blog.services;

import com.example.web_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {

    void save(Blog blog);

    Blog findBlogById(Long id);

    void removeBlog(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable);

    List<Blog> findAll();

    List<Blog> findAllByCategoryId(Long categoryId);

}
