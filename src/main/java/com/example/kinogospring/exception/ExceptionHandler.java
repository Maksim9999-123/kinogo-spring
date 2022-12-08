package com.example.kinogospring.exception;

import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handle(EntityNotFoundException ex){
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
    public ModelAndView castAndCrewBadRequest(BadRequestException ex){
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }

}
