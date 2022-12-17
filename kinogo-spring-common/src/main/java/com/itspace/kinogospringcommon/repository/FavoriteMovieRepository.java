package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringcommon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link FavoriteMovie}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface FavoriteMovieRepository extends JpaRepository<FavoriteMovie, Integer> {

    List<FavoriteMovie> findAllByUserId(int id);

}
