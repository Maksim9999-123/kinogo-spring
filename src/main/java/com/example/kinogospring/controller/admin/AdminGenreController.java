package com.example.kinogospring.controller.admin;


import com.example.kinogospring.model.entity.Genre;
import com.example.kinogospring.service.admin.AdminGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/genre")
@RequiredArgsConstructor
public class AdminGenreController {

    private final AdminGenreService adminGenreService;


    @GetMapping("/add")
    public String addMoviePage() {
        return "";
    }

    @PostMapping("/add")
    public String addGenre(@ModelAttribute Genre genre) {
        adminGenreService.save(genre);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editGenrePage(@RequestParam("genreId") int id, ModelMap modelMap) {
        Optional genreOptional = adminGenreService.getById(id);
        if (genreOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("genre", genreOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editGenre(@ModelAttribute Genre genre) {
        adminGenreService.save(genre);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteGenre(@PathVariable("id") int id) {
        adminGenreService.delete(id);
        return "redirect:/admin";
    }
}
