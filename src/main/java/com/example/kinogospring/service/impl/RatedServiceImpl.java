package com.example.kinogospring.service.impl;

import com.example.kinogospring.exception.MovieNotFoundException;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.model.entity.Rated;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.repository.RatedRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.example.kinogospring.service.RatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatedServiceImpl implements RatedService {
    private final RatedRepository ratedRepository;
    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;


    @Override
    public void saveRate(Rated rate, int movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow();
        User loggedInUser = userDetailService.getLoggedInUser();
        rate.setUser(loggedInUser);
        rate.setMovie(movie);
        movie.setTotalMovierate(movie.getTotalMovierate() + rate.getRate());
        ratedRepository.save(rate);
    }
}
