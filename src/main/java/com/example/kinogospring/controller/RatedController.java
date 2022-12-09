package com.example.kinogospring.controller;


import com.example.kinogospring.model.entity.Rated;
import com.example.kinogospring.service.RatedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/rate")
@RequiredArgsConstructor
public class RatedController {
    private final RatedService ratedService;

    @PostMapping("/{movieId}")
    public String rateMovie(@ModelAttribute @Valid Rated rated,
                            BindingResult bindingResult,
                            @PathVariable int movieId) {
        ratedService.saveRate(rated, movieId);
        return String.format("redirect:/moviesingle/%s", movieId);
    }
}
