package com.example.web_blog.services.impl;

import com.example.web_blog.model.Blog;
import com.example.web_blog.repositories.IBlogRepo;
import com.example.web_blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findBlogById(Long id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public void removeBlog(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> findAllByKeyword(String keyword) {
        return blogRepo.findAllByTitleContaining(keyword);
    }
}
