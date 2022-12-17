package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.FilmComment;

/**
 * Service interface for class {@link FilmComment}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */
public interface CommentService {

    void saveComment(FilmComment filmComment, int movieId);
}
