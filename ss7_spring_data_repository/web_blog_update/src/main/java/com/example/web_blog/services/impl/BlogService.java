package com.example.web_blog.services.impl;

import com.example.web_blog.model.Blog;
import com.example.web_blog.repositories.IBlogRepo;
import com.example.web_blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public void removeBlog(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepo.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return blogRepo.findAllByCategoryId(categoryId, pageable);
    }
}
