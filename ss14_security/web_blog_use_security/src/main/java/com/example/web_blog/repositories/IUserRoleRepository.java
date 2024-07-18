package com.example.web_blog.repositories;


import com.example.web_blog.model.AppUser;
import com.example.web_blog.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}