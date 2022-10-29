package com.example.kinogospring.controller;


import com.example.kinogospring.entity.User;
import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
@RequiredArgsConstructor
public class UserContoller {

    private final UserService userService;

    @GetMapping("/user/verify")
    public String verifyUser(@RequestParam("mail") String mail,
                             @RequestParam("token") String token) throws Exception {
        userService.verifyUser(mail,token);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) throws DuplicateResourceException, MessagingException {
        userService.save(user);
        return "redirect:/";
    }
}
