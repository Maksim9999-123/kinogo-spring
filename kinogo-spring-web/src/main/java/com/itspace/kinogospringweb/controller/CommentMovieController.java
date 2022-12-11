package com.itspace.kinogospringweb.controller;

import com.itspace.kinogospringcommon.model.entity.FilmComment;
import com.itspace.kinogospringcommon.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/comment")
public class CommentMovieController {

    private final CommentService commentService;


    @PostMapping("/{movieId}")
    public String filmComment(@ModelAttribute @Valid FilmComment filmComment,
                              BindingResult bindingResult,
                              @PathVariable int movieId) {
        commentService.saveComment(filmComment,movieId);
        return String.format("redirect:/moviesingle/%s", movieId);
    }
}
