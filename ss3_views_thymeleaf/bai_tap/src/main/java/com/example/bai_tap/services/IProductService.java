package com.example.bai_tap.services;

import com.example.bai_tap.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    Product findById(long id);

    void updateProduct(Product product);

    boolean deleteById(long id);

    List<Product> searchByName(String keyword);
}
