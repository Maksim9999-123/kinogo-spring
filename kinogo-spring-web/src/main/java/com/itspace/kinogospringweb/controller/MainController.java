package com.itspace.kinogospringweb.controller;

import com.example.kinogospring.exception.BadRequestException;
import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.model.entity.Genre;
import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.model.enums.Role;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.repository.RatedRepository;
import com.itspace.kinogospringweb.security.CurrentUser;
import com.example.kinogospring.service.CastCrewService;
import com.example.kinogospring.service.GenreService;
import com.example.kinogospring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;
    private final MovieService movieService;
    private final GenreService genreService;
    private final CastCrewService castCrewService;



    @GetMapping("/")
    public String mainPage(ModelMap modelMap) throws BadRequestException {
        List<Genre> genreList = genreService.findAll();
        List<Movie> movieList = movieService.findAll();
        List<CastCrew> castList = castCrewService.getAll();
        modelMap.addAttribute("genres", genreList);
        modelMap.addAttribute("movies", movieList);
        modelMap.addAttribute("castCrew", castList);
        return "index";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal CurrentUser currentUser){
        if(currentUser != null){
            User user = currentUser.getUser();
            if(user.getRole() == Role.ADMIN){
                return "redirect:/admin";
            }else if(user.getRole() == Role.USER){
                return "redirect:/";
            }
        }
        return "redirect:/";
    }


    @GetMapping("/castAndCrew/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("fileImage") String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPathImage + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }




}
