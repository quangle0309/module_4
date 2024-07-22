package com.example.web_blog.controllers;

import com.example.web_blog.model.Blog;
import com.example.web_blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public String index(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
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
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("blogs", blogService.findAllByKeyword(keyword));
        model.addAttribute("keyword", keyword);
        return "blog/index";
    }
}
