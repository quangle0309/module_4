package com.example.web_blog.controllers;

import com.example.web_blog.model.Blog;
import com.example.web_blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogsPage = blogService.findAll(pageable);
        if (blogsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogDetail(@PathVariable Long id){
        Blog blog = blogService.findBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getBlogList(@PathVariable Long categoryId){
        List<Blog> blogs = blogService.findAllByCategoryId(categoryId);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBlog(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 3);
        Page<Blog> blogsPage = blogService.findAllByTitleContaining(keyword, pageable);
        if (blogsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsPage, HttpStatus.OK);
    }
}
