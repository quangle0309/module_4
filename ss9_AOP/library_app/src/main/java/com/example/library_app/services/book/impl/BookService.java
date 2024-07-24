package com.example.library_app.services.book.impl;

import com.example.library_app.models.Book;
import com.example.library_app.repositories.book.IBookRepo;
import com.example.library_app.services.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo bookRepo;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
}
