package com.example.kinogospring.service.admin;

import com.example.kinogospring.model.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface AdminMovieService {
    void delete(int id);
    void save(Movie movie,MultipartFile[] files);
    String edit(Movie movie);

    Optional<Movie> getById(int id);
}
