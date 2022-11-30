package com.example.kinogospring.controller;

import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GenreController {

    private final GenreRepository genreRepository;

    private final MovieRepository movieRepository;

    @GetMapping("/genre/{id}")
    public String openGenre(@PathVariable("id") int id, ModelMap modelMap){
        List<Movie> allMovie = movieRepository.findAllById(id);

//        List<Movie> allMovie = movieRepository.findById(id);
        modelMap.addAttribute("movies", allMovie);
        return "moviegrid";
    }

    @GetMapping("/genre/add")
    public String addGenrePage(){
        return "addGenre";
    }

    @PostMapping("/genre/add")
    public String addGenre(@ModelAttribute Genre genre){
        genreRepository.save(genre);
        return "redirect:/";
    }
}