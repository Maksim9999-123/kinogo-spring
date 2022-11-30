package com.example.kinogospring.controller;

import com.example.kinogospring.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/castCrew")
@RequiredArgsConstructor
public class CastCrewController {

    private final GetService castCrewService;

    @GetMapping("/castcrew")
    public String getAllCastCrew(ModelMap modelMap) {
        List allCastCrew = castCrewService.getAll();
        modelMap.addAttribute("allCastCrew",allCastCrew);
        return "celebritygrid01";
    }

}
