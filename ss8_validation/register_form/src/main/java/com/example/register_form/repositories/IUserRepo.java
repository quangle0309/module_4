package com.example.register_form.repositories;

import com.example.register_form.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
}
