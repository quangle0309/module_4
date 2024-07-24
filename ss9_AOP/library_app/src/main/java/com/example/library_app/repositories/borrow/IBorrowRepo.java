package com.example.library_app.repositories.borrow;

import com.example.library_app.models.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepo extends JpaRepository<Borrow, Long> {
    Borrow findByCode(String code);
}
