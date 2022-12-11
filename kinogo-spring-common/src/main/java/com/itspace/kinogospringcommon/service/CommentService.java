package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FilmComment;

public interface CommentService {

    void saveComment(FilmComment filmComment, int movieId);
}
