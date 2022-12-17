package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.exception.MovieNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.repository.RatedRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.RatedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.MOVIE_NOT_FOUND;

/**
 * Implementation of {@link RatedService} interface.
 * Wrapper for {@link RatedRepository} + business logic for save user rate.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RatedServiceImpl implements RatedService {

    private final RatedRepository ratedRepository;
    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;


    @Override
    public Rated saveRate(Rated rate, int movieId) {
        Movie movie = movieRepository.findById(movieId);
        if(movie == null){
            throw new MovieNotFoundException(MOVIE_NOT_FOUND);
        }
        User loggedInUser = userDetailService.getLoggedInUser();
        rate.setUser(loggedInUser);
        rate.setMovie(movie);
        movie.setTotalMovierate(movie.getTotalMovierate() + rate.getRate());
        log.info("User with id{}: Rate Movie with id{}:", loggedInUser, movieId);
        return ratedRepository.save(rate);
    }
}
