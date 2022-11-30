package com.example.kinogospring.service.impl;

import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GetService<Genre> {

    private final GenreRepository genreRepository;


    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getById(int id) {
        return genreRepository.findById(id);
    }
}
