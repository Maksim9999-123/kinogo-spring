package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.FilmComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentMovieRepository extends JpaRepository<FilmComment, Integer> {
}
