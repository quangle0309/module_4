package com.example.library_app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "borrows")
@Data
public class Borrow {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String bookRenter;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
