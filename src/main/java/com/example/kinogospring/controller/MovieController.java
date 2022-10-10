package com.example.kinogospring.controller;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.entity.CastCrewRole;
import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    private final GenreRepository genreRepository;

    private final CastCrewRepository castCrewRepository;

    @Value("${kinogo.spring.images.folder}")
    private String folderPath;

    @GetMapping("/moviesingle")
    public String watchmovie(ModelMap modelMap){
        List<Movie> movieList = movieRepository.findAll();
        List<CastCrew> castCrewList = castCrewRepository.findAll();
        modelMap.addAttribute("movies", movieList);
        modelMap.addAttribute("castAndCrew", castCrewList);
        return "moviesingle";
    }


    @GetMapping("/movie/add")
    public String addMoviePage(ModelMap modelMap){
//        List<Genre> genreList = genreRepository.findAll();
//        modelMap.addAttribute("genres", genreList);
        return "addMovie";
    }

    @PostMapping("/movie/add")
    public String addMovie(@ModelAttribute Movie movie, @RequestParam("image")MultipartFile file) throws IOException {
        if(file.isEmpty()){
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File newFile = new File(folderPath + File.separator + fileName);
            file.transferTo(newFile);

        }
        movieRepository.save(movie);
        return "redirect:/moviegrid";
    }
}
