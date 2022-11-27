package com.example.kinogospring.controller;


//import com.example.kinogospring.service.CastCrewService;
import com.example.kinogospring.service.GenreService;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

//    private final CastCrewService castCrewService;
    private final GenreService genreService;

    @GetMapping()
    public String adminPage(ModelMap modelMap) {


        return "admin/admin";
    }


}
