package com.example.kinogospring.service.impl;

import com.example.kinogospring.model.entity.FilmComment;
import com.example.kinogospring.repository.CommentMovieRepository;
import com.example.kinogospring.service.CommentMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentMovieServiceImpl implements CommentMovieService {


    private final CommentMovieRepository commentMovieRepository;
    @Override
    public List<FilmComment> findCommentByMovieId(int id) {
        return commentMovieRepository.findAllByMovieId(id);
    }
}
