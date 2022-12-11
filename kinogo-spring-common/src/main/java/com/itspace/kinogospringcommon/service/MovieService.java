package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;

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
