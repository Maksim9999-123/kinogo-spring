package com.example.kinogospring.controller;

import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {

    private final MovieRepository movieRepository;

    @GetMapping("/genre/{id}")
    public String openGenre(@PathVariable("id") int id, ModelMap modelMap){
        List<Movie> allMovie = movieRepository.findAllById(id);
        modelMap.addAttribute("movies", allMovie);
        return "moviegrid";
    }
}