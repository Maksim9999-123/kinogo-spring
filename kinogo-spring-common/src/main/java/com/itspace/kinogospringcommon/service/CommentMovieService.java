package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FilmComment;

import java.util.List;

/**
 * Service interface for class {@link FilmComment}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */
public interface CommentMovieService {


    List<FilmComment> findCommentByMovieId(int id);
}
