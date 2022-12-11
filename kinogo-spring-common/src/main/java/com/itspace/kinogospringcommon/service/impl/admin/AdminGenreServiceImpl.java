package com.itspace.kinogospringcommon.service.impl.admin;

import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.repository.GenreRepository;
import com.itspace.kinogospringcommon.service.admin.AdminGenreService;
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
