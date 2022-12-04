package com.example.kinogospring.controller;


import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.model.entity.User;
import com.example.kinogospring.model.enums.Coutry;
import com.example.kinogospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;

    @GetMapping("/user/verify")
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
