package com.example.kinogospring.service;

import com.example.kinogospring.model.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();
    Optional<Movie> getById(int id);
    List<Movie> findAllById(int id);
    List<Movie> findTop20ByOrderByIdDesc();
    int count();
}
