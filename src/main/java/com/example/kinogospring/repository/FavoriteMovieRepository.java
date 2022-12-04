package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {

}
