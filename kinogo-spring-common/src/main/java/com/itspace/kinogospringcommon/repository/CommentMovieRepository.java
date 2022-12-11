package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentMovieRepository extends JpaRepository<FilmComment, Integer> {

    List<FilmComment> findAllByMovieId(int id);


}
