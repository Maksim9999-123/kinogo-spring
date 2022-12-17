package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link FilmComment}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface CommentMovieRepository extends JpaRepository<FilmComment, Integer> {

    List<FilmComment> findAllByMovieId(int id);


}
