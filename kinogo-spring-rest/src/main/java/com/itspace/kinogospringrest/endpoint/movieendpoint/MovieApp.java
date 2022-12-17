package com.itspace.kinogospringrest.endpoint.movieendpoint;

import com.itspace.kinogospringrest.dto.respons.MovieResponseDto;
import com.itspace.kinogospringrest.endpoint.movieendpoint.impl.MovieEndPoint;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * MovieApp interface for class {@link MovieEndPoint}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface MovieApp {

    List<MovieResponseDto> getAllMovies();

    ResponseEntity<?> getMovieById(int id) ;
}
