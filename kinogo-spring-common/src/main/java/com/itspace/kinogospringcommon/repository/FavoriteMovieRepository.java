package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {
    List<FavoriteMovie> findAllByUserId(int id);

}
