package com.example.kinogospring.controller;


import com.example.kinogospring.entity.Coutry;
import com.example.kinogospring.entity.MovieCountry;
import com.example.kinogospring.entity.User;
import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.repository.UserRepository;
import com.example.kinogospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserContoller {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam("mail") String mail,
                             @RequestParam("token") String token) throws Exception {
        userService.verifyUser(mail,token);
        return "redirect:/";
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




}
