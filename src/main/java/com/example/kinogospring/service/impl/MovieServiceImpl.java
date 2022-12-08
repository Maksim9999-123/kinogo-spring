package com.example.kinogospring.service.impl;

import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

//    @Override
//    public Optional<String> findByTrailer() {
//        return Optional.of(movieRepository.findMoviesByFilmTrailer().get().replace("watch?v=", "embed/"));
//    }

    @Override
    public Optional<Movie> getById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findAllById(int id) throws EntityNotFoundException {
        List<Movie> allById = movieRepository.findAllById(id);
        if(allById.isEmpty()){
            throw new EntityNotFoundException("No movie content for this id " + id);
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
