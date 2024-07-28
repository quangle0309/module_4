package com.example.user_manager_use_restful.services;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Long id);

    E save(E e);

    void remove(Long id);
}