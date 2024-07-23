package com.example.register_form.services.impl;

import com.example.register_form.models.User;
import com.example.register_form.repositories.IUserRepo;
import com.example.register_form.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;


    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
