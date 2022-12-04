package com.example.kinogospring.controller;

import com.example.kinogospring.model.entity.FilmComment;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.exception.MovieNotFoundException;
import com.example.kinogospring.repository.CommentMovieRepository;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.example.kinogospring.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentMovieController {

    private final CommentService commentService;


    @PostMapping("/{movieId}")
    public String filmComment(@ModelAttribute FilmComment filmComment, @PathVariable int movieId) {
        commentService.saveComment(filmComment,movieId);
        return String.format("redirect:/moviesingle/%s", movieId);
    }
}
