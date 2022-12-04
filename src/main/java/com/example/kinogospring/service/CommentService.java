package com.example.kinogospring.service;

import com.example.kinogospring.model.entity.FilmComment;

public interface CommentService {

    void saveComment(FilmComment filmComment, int movieId);
}
