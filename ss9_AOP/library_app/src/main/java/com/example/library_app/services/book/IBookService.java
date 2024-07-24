package com.example.library_app.services.book;

import com.example.library_app.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    void deleteById(Long id);

    Book findById(Long id);
}
