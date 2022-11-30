package com.example.kinogospring.repository;

import com.example.kinogospring.entity.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {

//    @Modifying
//    @Transactional
//    @Query(value = "insert into favorite_movie (user_id, movie_id) values (?user_id, ?movie_id)", nativeQuery = true)
//    Optional<FavoriteMovie> fav(@Param("user_id") int user_id, @Param("movie_id") int id);

}
