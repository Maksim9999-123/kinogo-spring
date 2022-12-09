package com.example.kinogospring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handle(EntityNotFoundException ex){
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }



}
