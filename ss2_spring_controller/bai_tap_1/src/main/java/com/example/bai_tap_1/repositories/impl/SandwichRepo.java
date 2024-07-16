package com.example.bai_tap_1.repositories.impl;

import com.example.bai_tap_1.repositories.ISandwichRepo;
import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepo implements ISandwichRepo {
    private static final String[] condiments = {"Lettuce", "Tomato", "Mustard", "Sprouts"};

    public String[] getAll() {
        return condiments;
    }
}
