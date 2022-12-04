package com.example.kinogospring.service.impl;

import com.example.kinogospring.model.entity.Genre;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public List<Genre> findAll(){
        return genreRepository.findAll();
    }
}
