package com.example.kinogospring.controller.admin;

import com.example.kinogospring.entity.Movie;
import com.example.kinogospring.service.GetService;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/movie")
@RequiredArgsConstructor
public class AdminMovieController {

    private final AdminService<Movie> adminService;
    private final GetService movieService;

    @GetMapping("/add")
    public String addMoviePage() {
        return "";
    }

    @PostMapping("/add")
    public String addCastCrew(@ModelAttribute Movie movie) {
        adminService.save(movie);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editMoviePage(@RequestParam("movieId") int id, ModelMap modelMap) {
        Optional movieOptional = movieService.getById(id);
        if (movieOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("movie", movieOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editMovie(@ModelAttribute Movie movie) {
        adminService.save(movie);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteMovie(@PathVariable("id") int id) {
        adminService.delete(id);
        return "redirect:/admin";
    }
}
