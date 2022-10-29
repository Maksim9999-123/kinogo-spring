package com.example.kinogospring.controller;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.entity.CastCrewRole;
import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.repository.GenreRepository;
import com.example.kinogospring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    private final GenreRepository genreRepository;
    private final CastCrewRepository castCrewRepository;

    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;

    @Value("${kinogo.spring.videos.folder}")
    private String folderPathVideos;

    @GetMapping("/movielist")
    public String getAllMovie(@ModelAttribute Movie movie, ModelMap modelMap){
        List<Movie> all = movieRepository.findTop20ByOrderByIdDesc();
        int countMovie = (int) movieRepository.count();
        modelMap.addAttribute("allMovie", all);
        modelMap.addAttribute("countMovie", countMovie);
        return "movielist";
    }


    @GetMapping("/moviesingle/{id}")
    public String watchmovie(@PathVariable("id") int id, ModelMap modelMap) {
        List<Movie> movieList = movieRepository.findAllById(id);
//        List<CastCrew> castCrewList = castCrewRepository.findAll();
        modelMap.addAttribute("movies", movieList);
//        modelMap.addAttribute("castAndCrew", castCrewList);
        return "moviesingle";
    }


    @GetMapping("/movie/add")
    public String addMoviePage(ModelMap modelMap) {
//        List<Genre> genreList = genreRepository.findAll();
//        modelMap.addAttribute("genres", genreList);
        return "addMovie";
    }

    @PostMapping("/movie/add")
    public String addMovie(@ModelAttribute Movie movie, @RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            if(fileName.endsWith(".mp4")){
                File newFile = new File(folderPathVideos + File.separator + fileName);
                file.transferTo(newFile);
                movie.setFilmVideo(fileName);
            }else {
                File newFile = new File(folderPathImage + File.separator + fileName);
                file.transferTo(newFile);
                movie.setFilmPic(fileName);
            }

        }
        movieRepository.save(movie);
        return "redirect:/";

    }

    @GetMapping("/movie/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImage + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }

    @GetMapping("/movie/getVideo")
    public @ResponseBody byte[] getVideo(@RequestParam("fileVideo") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathVideos + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }



}
