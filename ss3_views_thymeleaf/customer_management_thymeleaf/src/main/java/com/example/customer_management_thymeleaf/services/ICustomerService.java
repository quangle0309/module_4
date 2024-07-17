package com.example.customer_management_thymeleaf.services;

import com.example.customer_management_thymeleaf.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
