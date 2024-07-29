package com.example.web_blog.services.impl;

import com.example.web_blog.model.Category;
import com.example.web_blog.repositories.ICategoryRepo;
import com.example.web_blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void removeCategory(Long id) {
        categoryRepo.deleteById(id);
    }
}
