package com.example.kinogospring.service;


import java.util.List;
import java.util.Optional;

public interface GetService<T> {

    List<T> getAll();
    Optional<T> getById(int id);
}
