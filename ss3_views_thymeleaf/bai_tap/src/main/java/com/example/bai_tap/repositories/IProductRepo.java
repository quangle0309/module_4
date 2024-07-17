package com.example.bai_tap.repositories;

import com.example.bai_tap.models.Product;

import java.util.List;

public interface IProductRepo {
    Object getAll();

    void save(Product product);

    Object findById(int id);

    void updateProduct(Product product);

    boolean deleteById(int id);

    List<Product> searchByName(String name);
}
