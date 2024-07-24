package com.example.library_app.dto;

import com.example.library_app.models.Book;

public interface IBorrowDTO {
    Long getId();
    String getCode();
    String getBookRenter();
    Book getBook();
}
