package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentMovieRepository extends JpaRepository<FilmComment, Integer> {

    List<FilmComment> findAllByMovieId(int id);
}
