package com.itspace.kinogospringcommon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException {

}
