package com.example.bai_tap.services;

import com.example.bai_tap.models.Product;

import java.util.List;

public interface IProductService {
    Object getAll();

    void save(Product product);

    Object findById(int id);

    void updateProduct(Product product);

    boolean deleteByid(int id);

    List<Product> searchByName(String name);
}
