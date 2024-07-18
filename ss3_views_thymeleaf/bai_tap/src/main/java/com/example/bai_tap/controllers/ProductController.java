package com.example.bai_tap.controllers;

import com.example.bai_tap.models.Product;
import com.example.bai_tap.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("products", productService.getAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.updateProduct(product);
        redirect.addFlashAttribute("updateMessage", "Chỉnh sửa thành công");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes redirect) {
        boolean result = productService.deleteById(id);
        redirect.addFlashAttribute("deleteMessage", result);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("products", productService.searchByName(keyword));
        return "/list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
}
