package com.example.library_app.services.borrow;

import com.example.library_app.models.Borrow;

import java.util.List;

public interface IBorrowService {
    Borrow borrowBook(Long bookId, String bookRenter);

    boolean returnBook(String code);

    List<Borrow> findAll();
}
