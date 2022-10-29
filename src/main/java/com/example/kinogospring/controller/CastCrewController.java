package com.example.kinogospring.controller;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.repository.CastCrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CastCrewController {

    private final CastCrewRepository castCrew;

    @GetMapping("/castcrew")
    public String getAllCastCrew(ModelMap modelMap) {
        List<CastCrew> allCastCrew = castCrew.findAll();
        modelMap.addAttribute("allCastCrew",allCastCrew);
        return "celebritygrid01";
    }

    @GetMapping("/castcrew/add")
    public String addCastCrew() {
        return "form_admin";
    }

    @PostMapping("/castcrew/add")
    public String addCastCrew(@ModelAttribute CastCrew castCrew1){
        castCrew.save(castCrew1);
        return "redirect:/";
    }
}
