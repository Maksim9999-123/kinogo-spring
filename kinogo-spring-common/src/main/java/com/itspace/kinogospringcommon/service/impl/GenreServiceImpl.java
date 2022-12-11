package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.repository.GenreRepository;
import com.itspace.kinogospringcommon.service.GenreService;
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
