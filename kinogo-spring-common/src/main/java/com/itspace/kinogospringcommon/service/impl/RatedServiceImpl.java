package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.repository.RatedRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.RatedService;
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
