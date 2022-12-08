package com.example.kinogospring.service;

import com.example.kinogospring.model.entity.FavoriteMovie;

import java.util.List;

public interface FavoriteService {

    void favoriteMovie(int movieId);
    List<FavoriteMovie> findAll();
}
