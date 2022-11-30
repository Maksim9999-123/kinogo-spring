package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminGenreServiceImpl implements AdminService<Genre> {

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
}
