package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;

import java.util.List;

public interface FavoriteService {

    void favoriteMovie(int movieId);
    List<FavoriteMovie> findAll();
}
