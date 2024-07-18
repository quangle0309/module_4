package com.example.bai_tap.repositories.impl;

import com.example.bai_tap.models.Product;
import com.example.bai_tap.repositories.IProductRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository (value = "productRepo")
public class ProductRepo implements IProductRepo {

    @Override
    public List<Product> getAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select s from products s", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public Product findById(long id) {
        return BaseRepository.entityManager.createQuery("SELECT p FROM products AS p WHERE p.id = :id", Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            BaseRepository.entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public boolean deleteById(long id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        transaction.commit();
        return true;
    }

    @Override
    public List<Product> searchByName(String name) {
        return BaseRepository.entityManager.createQuery("Select p from products p where p.name like :name", Product.class).setParameter("name", "%" + name + "%").getResultList();
    }
}
