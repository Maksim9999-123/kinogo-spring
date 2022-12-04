package com.example.kinogospring.controller;


import com.example.kinogospring.model.entity.Rated;
import com.example.kinogospring.repository.RatedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rate")
@RequiredArgsConstructor
public class RatedController {


    private final RatedRepository ratedRepository;

    @PostMapping()
    public String rateMovie(@ModelAttribute Rated rated) {
        ratedRepository.save(rated);
        return "index";
    }
}
