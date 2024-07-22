package com.example.service;


import com.example.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}