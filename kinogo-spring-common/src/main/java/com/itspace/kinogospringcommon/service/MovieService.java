package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.Movie;

import java.util.List;

/**
 * Service interface for class {@link Movie}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */

public interface MovieService {

    List<Movie> findAll();

    List<Movie> findAllById(int id);

    Movie getById(int id);

    List<Movie> findTop20ByOrderByIdDesc();

    int count();
}
