package com.example.kinogospring.controller.admin;


import com.example.kinogospring.entity.Genre;
import com.example.kinogospring.service.GetService;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/genre")
@RequiredArgsConstructor
public class AdminGenreController {

    private final AdminService<Genre> adminService;
    private final GetService getService;

    @GetMapping("/add")
    public String addMoviePage() {
        return "";
    }

    @PostMapping("/add")
    public String addGenre(@ModelAttribute Genre genre) {
        adminService.save(genre);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editGenrePage(@RequestParam("genreId") int id, ModelMap modelMap) {
        Optional genreOptional = getService.getById(id);
        if (genreOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("genre", genreOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editGenre(@ModelAttribute Genre genre) {
        adminService.save(genre);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteGenre(@PathVariable("id") int id) {
        adminService.delete(id);
        return "redirect:/admin";
    }
}
