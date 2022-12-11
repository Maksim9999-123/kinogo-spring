package com.itspace.kinogospringcommon.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
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
