package com.example.web_blog.services;

import com.example.web_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findBlogById(Long id);

    void removeBlog(Long id);

    List<Blog> findAllByKeyword(String keyword);
}
