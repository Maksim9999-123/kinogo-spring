package com.itspace.kinogospringrest.endpoint.movieendpoint.impl;


import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.MovieService;
import com.itspace.kinogospringrest.dto.respons.MovieResponseDto;
import com.itspace.kinogospringrest.endpoint.movieendpoint.MovieApp;
import com.itspace.kinogospringrest.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Movie requests.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieEndPoint implements MovieApp {

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    private final UserDetailServiceImpl userDetailService;

    @GetMapping
    public List<MovieResponseDto> getAllMovies(){
        int userId = userDetailService.getLoggedInUser().getId();
        log.info("Try to get all movies by user with id: {}",userId);
        return movieMapper.mapToResponseList(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id){
        int userId = userDetailService.getLoggedInUser().getId();
        log.info("Try to get movie by user with id: {}",userId);
        Movie movie = movieService.getById(id);
        return ResponseEntity.ok(movieMapper.mapToResponseDto(movie));
    }
}
