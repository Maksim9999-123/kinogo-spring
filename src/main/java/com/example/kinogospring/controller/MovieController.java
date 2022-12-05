package com.example.kinogospring.controller;

import com.example.kinogospring.model.entity.FilmComment;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.service.CommentMovieService;
import com.example.kinogospring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MovieController {


    private final MovieService movieService;
    private final CommentMovieService commentMovieService;

    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;

    @Value("${kinogo.spring.videos.folder}")
    private String folderPathVideos;

    @GetMapping("/movielist")
    public String getAllMovie(@ModelAttribute Movie movie, ModelMap modelMap) {
        List<Movie> all = movieService.findTop20ByOrderByIdDesc();
        int countMovie = movieService.count();
        modelMap.addAttribute("allMovie", all);
        modelMap.addAttribute("countMovie", countMovie);
        return "movielist";
    }


    @GetMapping("/moviesingle/{id}")
    public String watchmovie(@PathVariable("id") int id, ModelMap modelMap) {
        List<Movie> movieList = movieService.findAllById(id);
        List<FilmComment> commentList = commentMovieService.findCommentByMovieId(id);
//        Optional<String> byTrailer = movieService.findByTrailer();
        modelMap.addAttribute("comments", commentList);
        modelMap.addAttribute("movies", movieList);
//        modelMap.addAttribute("filmTrailer", byTrailer);
        return "moviesingle";
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
