package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMovieServiceImpl implements AdminService<Movie> {

    private final MovieRepository movieRepository;


    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }
    @Override
    public void save(Movie movie) {

        movieRepository.save(movie);
    }

    @Override
    public String edit(Movie movie) {
        return null;
    }
}
