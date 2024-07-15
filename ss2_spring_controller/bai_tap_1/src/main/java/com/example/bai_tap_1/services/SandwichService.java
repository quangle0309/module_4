package com.example.bai_tap_1.services;

import com.example.bai_tap_1.repositories.SandwichRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService {
    @Autowired
    SandwichRepo sandwichRepo;

    public String[] getAll() {
        return sandwichRepo.getAll();
    }
}
