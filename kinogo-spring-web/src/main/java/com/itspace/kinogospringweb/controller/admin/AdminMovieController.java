package com.itspace.kinogospringweb.controller.admin;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.service.admin.AdminMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin/movie")
@RequiredArgsConstructor
public class AdminMovieController {

    private final AdminMovieService adminMovieService;


    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;

    @Value("${kinogo.spring.videos.folder}")
    private String folderPathVideos;

    @GetMapping("/add")
    public String addMoviePage() {
        return "admin_movie_add";
    }


    @PostMapping("/add")
    public String addCastCrew(@ModelAttribute @Valid Movie movie,
                              BindingResult bindingResult,
                              @RequestParam("files") MultipartFile[] files) {
        adminMovieService.save(movie,files);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editMoviePage(@RequestParam("movieId") int id, ModelMap modelMap) {
        Optional movieOptional = adminMovieService.getById(id);
        if (movieOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("movie", movieOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editMovie(@ModelAttribute @Valid Movie movie,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_movie_add";
        }
        // adminMovieService.save(movie);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteMovie(@PathVariable("id") int id) {
        adminMovieService.delete(id);
        return "redirect:/admin";
    }
}
