package com.example.kinogospring.controller;

import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.entity.Role;
import com.example.kinogospring.entity.User;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.security.CurrentUser;
import com.example.kinogospring.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final GenreService genreService;
    private final MovieRepository movieRepository;
//    private final UserService userService;


    @GetMapping("/")
    public String mainPage(ModelMap modelMap){
        List<Genre> genreList = genreService.findAll();
        List<Movie> movieList = movieRepository.findAll();
        modelMap.addAttribute("genres", genreList);
        modelMap.addAttribute("movies", movieList);
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

//    @RequestMapping("/search")
//    public String search(ModelMap modelMap, @RequestParam String keyword){
//        List<Movie> result = movieRepository.search(keyword);
//        modelMap.addAttribute("res", result);
//        return "index";
//    }


}
