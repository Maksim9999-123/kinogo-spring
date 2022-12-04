package com.example.kinogospring.service.impl;

import com.example.kinogospring.model.entity.FavoriteMovie;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.exception.MovieNotFoundException;
import com.example.kinogospring.repository.FavoriteMovieRepository;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.example.kinogospring.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;
    private final FavoriteMovieRepository favoriteMovieRepository;

    public void favoriteMovie(int movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(MovieNotFoundException::new);
        User loggedInUser = userDetailService.getLoggedInUser();
        FavoriteMovie favoriteMovie = FavoriteMovie.builder()
                .user(loggedInUser)
                .movie(movie)
                .build();
        favoriteMovieRepository.save(favoriteMovie);
    }


}
