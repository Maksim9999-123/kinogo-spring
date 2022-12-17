package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;

import java.util.List;

/**
 * Service interface for class {@link FavoriteMovie}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */
public interface FavoriteService {

    void favoriteMovie(int movieId);

    List<FavoriteMovie> findAll();
}
