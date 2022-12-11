package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.model.entity.FilmComment;
import com.itspace.kinogospringcommon.repository.CommentMovieRepository;
import com.itspace.kinogospringcommon.service.CommentMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentMovieServiceImpl implements CommentMovieService {


    private final CommentMovieRepository commentMovieRepository;
    @Override
    public List<FilmComment> findCommentByMovieId(int id) {
        return commentMovieRepository.findAllByMovieId(id);
    }
}
