package com.example.kinogospring.service;

import com.example.kinogospring.exception.BadRequestException;
import com.example.kinogospring.model.entity.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll() throws BadRequestException;
}
