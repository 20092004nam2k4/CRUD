package com.example.demo.service;

import com.example.demo.model.Staff;

import java.util.Optional;

public interface IGenerateService <T> {
    Iterable<T> findAll();
    Optional<T> findByID(Long id);
    void save(T t);
    void remote(Long id);

    Staff getCustomerById(Long id);
}
