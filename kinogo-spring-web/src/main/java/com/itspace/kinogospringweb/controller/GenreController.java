package com.itspace.kinogospringweb.controller;

import com.example.kinogospring.exception.BadRequestException;
import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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