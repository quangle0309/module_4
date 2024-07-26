package com.example.library_app.services.borrow.impl;

import com.example.library_app.models.Book;
import com.example.library_app.models.Borrow;
import com.example.library_app.repositories.book.IBookRepo;
import com.example.library_app.repositories.borrow.IBorrowRepo;
import com.example.library_app.services.borrow.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepo borrowRepo;

    @Autowired
    private IBookRepo bookRepo;

    public Borrow borrowBook(Long bookId, String bookRenter) {
        Book book = bookRepo.findById(bookId).orElse(null);
        if (book == null || book.getQuantity() <= 0) {
            return null;
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBookRenter(bookRenter);
        borrow.setCode(generateBorrowCode());
        borrowRepo.save(borrow);

        return borrow;
    }


    public void returnBook(Borrow borrow) {
        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);
        borrowRepo.delete(borrow);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepo.findAll();
    }

    @Override
    public Borrow findByCode(String code) {
        return borrowRepo.findByCode(code);
    }

    private String generateBorrowCode() {
        Random random = new Random();
        String code;
        do {
            code = String.format("MS-%05d", random.nextInt(100000));
        } while (borrowRepo.findByCode(code) != null);
        return code;
    }
}
