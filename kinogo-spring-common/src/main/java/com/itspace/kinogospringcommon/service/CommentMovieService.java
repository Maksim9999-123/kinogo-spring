package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FilmComment;


import java.util.List;

public interface CommentMovieService {


    List<FilmComment> findCommentByMovieId(int id);
}
