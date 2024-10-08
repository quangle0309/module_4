package com.example.library_app.controllers;

import com.example.library_app.models.Book;
import com.example.library_app.models.Borrow;
import com.example.library_app.services.book.IBookService;
import com.example.library_app.services.borrow.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "admin/books")
public class AdminController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    @GetMapping("")
    public String list(Model model,
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Book> books = bookService.findAll(PageRequest.of(page, 12));
        model.addAttribute("books", books);
        return "admin/book/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "admin/book/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes redirect) {
        bookService.save(book);
        redirect.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/admin/books";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirect) {
        bookService.deleteById(id);
        redirect.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/admin/books";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "admin/book/update";
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/admin/books";
    }

    @GetMapping("/borrow")
    public String borrow(Model model) {
        model.addAttribute("borrows", borrowService.findAll());
        return "admin/borrow/list";
    }
}
