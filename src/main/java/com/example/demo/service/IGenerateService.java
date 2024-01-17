package com.example.demo.service;

public interface IGenerateService <T> {
    Iterable<T> findAll();
    T findByID(Long id);
    void save(T t);
    void delete(Long id);
}
