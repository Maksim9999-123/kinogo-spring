package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.exception.MovieNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.MOVIE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public Movie getById(int id) {
        if(id >= 0){
            throw new MovieNotFoundException(MOVIE_NOT_FOUND);
        }
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findAllById(int id){
        List<Movie> allById = movieRepository.findAllById(id);
        if (allById.isEmpty()) {
            throw new MovieNotFoundException(MOVIE_NOT_FOUND);
        }
        for (Movie movie : allById) {
            movie.setVieweing(movie.getVieweing() + 1);
            movieRepository.save(movie);
        }
        return allById;
    }

    @Override
    public List<Movie> findTop20ByOrderByIdDesc() {
        return movieRepository.findTop20ByOrderByIdDesc();
    }

    @Override
    public int count() {
        return (int) movieRepository.count();
    }
}
