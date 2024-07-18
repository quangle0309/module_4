package com.example.bai_tap.services.impl;

import com.example.bai_tap.models.Product;
import com.example.bai_tap.repositories.IProductRepo;
import com.example.bai_tap.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepo.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    @Override
    public boolean deleteById(long id) {
        return productRepo.deleteById(id);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepo.searchByName(keyword);
    }
}
