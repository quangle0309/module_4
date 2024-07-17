package com.example.bai_tap.repositories.impl;

import com.example.bai_tap.models.Product;
import com.example.bai_tap.repositories.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone XR", 1000, "Thiết kế hiện đại, hiệu suất mạnh mẽ.", "Apple"));
        products.add(new Product(2, "Samsung S23", 1400, "Mẫu sản phẩm nổi tiếng của nhà Samsung", "Samsung"));
        products.add(new Product(3, "Xiaomi mi13", 990, "Cấu hình mạnh mẽ, thiết kế đẹp đẽ", "Xiaomi"));
        products.add(new Product(4, "Redmi k50 Gaming", 890, "Gaming phone của nhà redmi", "Redmi"));
        products.add(new Product(5, "Iphone 15 plus", 1900, "Tạo vấn đề, bán giải pháp", "Apple"));
    }

    @Override
    public Object getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(products.get(products.size()-1).getId() + 1);
        products.add(product);
    }

    @Override
    public Object findById(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacturer(product.getManufacturer());
            }
        }
    }

    @Override
    public boolean deleteById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                searchProducts.add(product);
            }
        }
        return searchProducts;
    }
}
