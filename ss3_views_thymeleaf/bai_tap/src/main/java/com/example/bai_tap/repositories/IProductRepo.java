package com.example.bai_tap.repositories;

import com.example.bai_tap.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAll();

    void save(Product product);

    Product findById(long id);

    void updateProduct(Product product);

    boolean deleteById(long id);

    List<Product> searchByName(String name);
}
