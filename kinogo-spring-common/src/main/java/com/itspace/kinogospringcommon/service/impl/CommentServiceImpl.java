package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.exception.ErrorHandler;
import com.itspace.kinogospringcommon.model.entity.FilmComment;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.CommentMovieRepository;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.MOVIE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMovieRepository commentMovieRepository;
    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;

    @Override
    public void saveComment(FilmComment filmComment, int movieId) {
        Movie movie = movieRepository.findById(movieId);
        User loggedInUser = userDetailService.getLoggedInUser();
        FilmComment commentFilm = FilmComment.builder()
                .user(loggedInUser)
                .movie(movie)
                .comment(filmComment.getComment())
                .build();
        commentMovieRepository.save(commentFilm);
    }
}
