package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {
    List<FavoriteMovie> findAllByUserId(int id);

}
