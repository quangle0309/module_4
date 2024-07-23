package com.example.web_blog.controllers;

import com.example.web_blog.model.Blog;
import com.example.web_blog.services.IBlogService;
import com.example.web_blog.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping(value = "blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category/{id}")
    public String listByCategory(@PathVariable Long id, Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Blog> blogsPage = blogService.findAllByCategoryId(id, pageable);
        model.addAttribute("blogsPage", blogsPage);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.removeBlog(id);
      return "redirect:/blogs/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "blog/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Blog> blogsPage = blogService.findAllByTitleContaining(keyword, pageable);
        model.addAttribute("blogsPage", blogsPage);
        model.addAttribute("keyword", keyword);
        return "blog/index";
    }

    @GetMapping("/list")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Blog> blogsPage = blogService.findAll(pageable);
        model.addAttribute("blogsPage", blogsPage);
        return "blog/index";
    }
}
