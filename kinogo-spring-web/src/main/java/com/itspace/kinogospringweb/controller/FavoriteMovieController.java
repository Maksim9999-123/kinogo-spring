package com.itspace.kinogospringweb.controller;

import com.itspace.kinogospringcommon.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/favorite")
public class FavoriteMovieController{

    private final FavoriteService favoriteService;


    @PostMapping("/{movieId}")
    public String openFavorite(@PathVariable int movieId){
        favoriteService.favoriteMovie(movieId);
        return String.format("redirect:/moviesingle/%s", movieId);
    }
}