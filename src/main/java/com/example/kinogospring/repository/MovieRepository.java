package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Integer> {


    List<Movie> findAllById(int id);

    List<Movie> findTop20ByOrderByIdDesc();

//    Optional<String> findMoviesByFilmTrailer();

}
