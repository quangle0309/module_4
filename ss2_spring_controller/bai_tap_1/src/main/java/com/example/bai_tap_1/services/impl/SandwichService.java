package com.example.bai_tap_1.services.impl;

import com.example.bai_tap_1.repositories.impl.SandwichRepo;
import com.example.bai_tap_1.services.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    SandwichRepo sandwichRepo;

    @Override
    public String[] getAll() {
        return sandwichRepo.getAll();
    }
}
