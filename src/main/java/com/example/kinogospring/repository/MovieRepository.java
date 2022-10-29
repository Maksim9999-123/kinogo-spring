package com.example.kinogospring.repository;

import com.example.kinogospring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findMovieById(Integer integer);

}
