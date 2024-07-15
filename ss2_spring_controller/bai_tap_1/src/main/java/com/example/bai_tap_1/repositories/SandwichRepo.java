package com.example.bai_tap_1.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepo {
    private static final String[] condiments = {"Lettuce", "Tomato", "Mustard", "Sprouts"};

    public String[] getAll() {
        return condiments;
    }
}
