package com.itspace.kinogospringweb.controller;

import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringcommon.service.RatedService;
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
