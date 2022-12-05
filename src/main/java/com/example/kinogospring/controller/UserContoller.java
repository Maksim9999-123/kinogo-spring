package com.example.kinogospring.controller;


import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.model.entity.FavoriteMovie;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.model.enums.Coutry;
import com.example.kinogospring.repository.FavoriteMovieRepository;
import com.example.kinogospring.security.UserDetailServiceImpl;
import com.example.kinogospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;
    private final UserDetailServiceImpl userDetailService;

    private final FavoriteMovieRepository favoriteMovieRepository;


    @GetMapping("/favorite")
    public String userFavoritePage(ModelMap modelMap) {
        List<FavoriteMovie> userFavorite = favoriteMovieRepository.findAll();
        modelMap.addAttribute("userFavoriteList", userFavorite);
        return "userfavoritegrid";
    }

    @GetMapping("/profile")
    public String userBioPage(ModelMap modelMap){
        User loggedInUser = userDetailService.getLoggedInUser();
        modelMap.addAttribute("currentUserBio", loggedInUser);
        return "userprofile";
    }

    @GetMapping("/verify")
    public String verifyUser(@RequestParam(value = "email") String email,
                             @RequestParam(value = "token") String token) throws Exception {
        userService.verifyUser(email, token);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registerPage(ModelMap modelMap) {
        Coutry[] countryList = Coutry.values();
        modelMap.addAttribute("countries", countryList);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user,
                          ModelMap modelMap) throws MessagingException, DuplicateResourceException {
        Optional<User> byEmail = userService.findByEmail(user.getEmail());
        if (byEmail.isPresent()) {
            modelMap.addAttribute("errorMessageEmail", "Email already in use");
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
