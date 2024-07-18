package com.example.web_blog.repositories;


import com.example.web_blog.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}