package com.codegym.c0324h1_spring_boot_2.repositories;

import com.codegym.c0324h1_spring_boot_2.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}