package com.example.library_app.repositories.book;

import com.example.library_app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book, Long> {
}
