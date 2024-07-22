package com.example.web_blog.repositories;

import com.example.web_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Long> {
}

