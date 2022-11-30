package com.example.kinogospring.service.impl;

import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieSercviceImpl implements GetService<Movie> {

    private final MovieRepository movieRepository;


    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(int id) {
        return movieRepository.findById(id);
    }
}
