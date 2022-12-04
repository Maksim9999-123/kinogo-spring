package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.model.entity.Genre;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.service.adminservice.AdminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminGenreServiceImpl implements AdminGenreService {

    private final GenreRepository genreRepository;

    @Override
    public void delete(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public String edit(Genre genre) {
        return null;
    }

    @Override
    public Optional getById(int id) {
        return genreRepository.findById(id);
    }
}
