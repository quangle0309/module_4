package com.example.web_blog.controllers;

import com.example.web_blog.model.Category;
import com.example.web_blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> addCategoriesToModel() {
        return categoryService.findAll();
    }
}
