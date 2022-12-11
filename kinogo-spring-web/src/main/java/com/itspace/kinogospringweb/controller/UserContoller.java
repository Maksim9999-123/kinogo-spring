package com.itspace.kinogospringweb.controller;


import com.itspace.kinogospringcommon.exception.DuplicateResourceException;
import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.model.entity.Coutry;
import com.itspace.kinogospringcommon.model.entity.Gender;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.FavoriteService;
import com.itspace.kinogospringcommon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;
    private final UserDetailServiceImpl userDetailService;
    private final FavoriteService favoriteService;


    @GetMapping("/favorite")
    public String userFavoritePage(ModelMap modelMap) {
        List<FavoriteMovie> userFavorite = favoriteService.findAll();
        modelMap.addAttribute("userFavoriteList", userFavorite);
        return "userfavoritegrid";
    }

    @GetMapping("/profile")
    public String userBioPage(ModelMap modelMap){
        User loggedInUser = userDetailService.getLoggedInUser();
        Coutry[] country = Coutry.values();
        Gender[] gender = Gender.values();
        modelMap.addAttribute("currentUserBio", loggedInUser);
        modelMap.addAttribute("countryList", country);
        modelMap.addAttribute("genderList", gender);
        return "userprofile";
    }

    @PostMapping("/profile/update")
    public String updateUser(@RequestParam(value = "name") String name, @RequestParam("surname") String surname) throws MessagingException, DuplicateResourceException {
        User loggedInUser = userDetailService.getLoggedInUser();
        loggedInUser.setName(name);
        loggedInUser.setSurname(surname);
        userService.update(loggedInUser);
        return "redirect:/user/profile";
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
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindingResult,
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
