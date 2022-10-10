package com.example.kinogospring.controller;

import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap){
        List<Genre> genreList = genreRepository.findAll();
        modelMap.addAttribute("genres", genreList);
        return "index";
    }





}
