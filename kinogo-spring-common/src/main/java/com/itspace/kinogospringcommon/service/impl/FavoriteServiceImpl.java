package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.FavoriteMovieRepository;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;
    private final FavoriteMovieRepository favoriteMovieRepository;

    public void favoriteMovie(int movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow();
        User loggedInUser = userDetailService.getLoggedInUser();
        FavoriteMovie favoriteMovie = FavoriteMovie.builder()
                .user(loggedInUser)
                .movie(movie)
                .build();
        favoriteMovieRepository.save(favoriteMovie);
    }

    @Override
    public List<FavoriteMovie> findAll() {
        return favoriteMovieRepository.findAll();
    }


}
