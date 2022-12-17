package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Movie}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    List<Movie> findAllById(int id);

   Movie findById(int id);

    List<Movie> findTop20ByOrderByIdDesc();


}
