package com.example.web_blog.repositories;

import com.example.web_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog, Long> {
    List<Blog> findAllByTitleContaining(String keyword);
}
