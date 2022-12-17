package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.exception.ErrorHandler;
import com.itspace.kinogospringcommon.exception.MovieNotFoundException;
import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.FavoriteMovieRepository;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.repository.RatedRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.FavoriteService;
import com.itspace.kinogospringcommon.service.RatedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.MOVIE_NOT_FOUND;


/**
 * Implementation of {@link FavoriteService} interface.
 * Wrapper for {@link FavoriteMovieRepository} + business logic for save user favorite movie.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;
    private final FavoriteMovieRepository favoriteMovieRepository;


    public void favoriteMovie(int movieId) {
        Movie movie = movieRepository.findById(movieId);
        if(movie== null){
            throw new MovieNotFoundException(MOVIE_NOT_FOUND);
        }
        User loggedInUser = userDetailService.getLoggedInUser();
        FavoriteMovie favoriteMovie = FavoriteMovie.builder()
                .user(loggedInUser)
                .movie(movie)
                .build();
        log.info("User with id{}: Favorite Movie with id{}:", loggedInUser, movieId);
        favoriteMovieRepository.save(favoriteMovie);
    }

    @Override
    public List<FavoriteMovie> findAll() {
        return favoriteMovieRepository.findAll();
    }


}
