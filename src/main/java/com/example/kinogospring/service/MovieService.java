package com.example.kinogospring.service;

import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

//    Optional<String>findByTrailer();
    Optional<Movie> getById(int id) throws EntityNotFoundException;
    List<Movie> findAllById(int id) throws EntityNotFoundException;
    List<Movie> findTop20ByOrderByIdDesc();
    int count();
}
