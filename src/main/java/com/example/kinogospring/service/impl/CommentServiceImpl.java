package com.example.kinogospring.service.impl;

import com.example.kinogospring.exception.MovieNotFoundException;
import com.example.kinogospring.model.entity.FilmComment;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.repository.CommentMovieRepository;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.example.kinogospring.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMovieRepository commentMovieRepository;
    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;

    @Override
    public void saveComment(FilmComment filmComment, int movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(MovieNotFoundException::new);
        User loggedInUser = userDetailService.getLoggedInUser();
        FilmComment commentFilm = FilmComment.builder()
                .user(loggedInUser)
                .movie(movie)
                .comment(filmComment.getComment())
                .build();
        commentMovieRepository.save(commentFilm);
    }
}
