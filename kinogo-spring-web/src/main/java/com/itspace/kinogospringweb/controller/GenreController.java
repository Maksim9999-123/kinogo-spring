package com.itspace.kinogospringweb.controller;


import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GenreController {
    private final MovieService movieService;

    @GetMapping("/genre/{id}")
    public String openGenre(@PathVariable("id") int id, ModelMap modelMap) throws EntityNotFoundException {
        List<Movie> allMovie = movieService.findAllById(id);
        modelMap.addAttribute("movies", allMovie);
        return "moviegrid";
    }
}