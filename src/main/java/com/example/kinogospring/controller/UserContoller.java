package com.example.kinogospring.controller;


import com.example.kinogospring.entity.Coutry;
import com.example.kinogospring.entity.User;
import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.repository.FavoriteMovieRepository;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.repository.UserRepository;
import com.example.kinogospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserContoller {

    private final UserService userService;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final FavoriteMovieRepository favoriteMovieRepository;

    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam(value = "email") String email,
                             @RequestParam(value = "token") String token) throws Exception {
        userService.verifyUser(email,token);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registerPage(ModelMap modelMap){
        Coutry[] countryList = Coutry.values();
        modelMap.addAttribute("countries", countryList);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user,
                          ModelMap modelMap) throws MessagingException, DuplicateResourceException{
        Optional<User> byEmail = userService.findByEmail(user.getEmail());
        if (byEmail.isPresent()) {
            modelMap.addAttribute("errorMessageEmail", "Email already in use");
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

//    @GetMapping("/favorite/{id}")
//    public String favorite(@PathVariable("id") int id, Principal principal){
//        String name = principal.getName();
//        favoriteMovieRepository.fav(10, id);
//        return null;
//
//    }



}
