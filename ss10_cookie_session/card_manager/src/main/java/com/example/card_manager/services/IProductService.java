package com.example.card_manager.services;

import com.example.card_manager.models.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product findProductById(Long id);
}
