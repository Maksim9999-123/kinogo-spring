package com.example.kinogospring.service;

import com.example.kinogospring.model.entity.FilmComment;


import java.util.List;
import java.util.Optional;

public interface CommentMovieService {


    List<FilmComment> findCommentByMovieId(int id);
}
