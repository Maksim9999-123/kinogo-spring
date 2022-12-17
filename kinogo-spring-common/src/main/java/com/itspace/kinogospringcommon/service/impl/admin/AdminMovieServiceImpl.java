package com.itspace.kinogospringcommon.service.impl.admin;

import com.itspace.kinogospringcommon.exception.MovieNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.repository.GenreRepository;
import com.itspace.kinogospringcommon.repository.MovieRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.admin.AdminGenreService;
import com.itspace.kinogospringcommon.service.admin.AdminMovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.MOVIE_NOT_FOUND;

/**
 * Implementation of {@link AdminMovieService} interface.
 * Wrapper for {@link MovieRepository} + business logic.
 *
 * @author Maksim Aslanyan
 * @author Albert Nadoyan
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AdminMovieServiceImpl implements AdminMovieService {


    private final MovieRepository movieRepository;
    private final UserDetailServiceImpl userDetailService;

    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;

    @Value("${kinogo.spring.videos.folder}")
    private String folderPathVideos;

    @Override
    public void delete(int id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(MOVIE_NOT_FOUND);
        }
        movieRepository.deleteById(id);
    }

    @Override
    public Movie save(Movie movie, MultipartFile[] files) {
        for (MultipartFile file : files) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            if (fileName.endsWith(".mp4")) {
                File newFile = new File(folderPathVideos + File.separator + fileName);
                try {
                    file.transferTo(newFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                movie.setFilmVideo(fileName);
            } else {
                File newFile = new File(folderPathImage + File.separator + fileName);
                try {
                    file.transferTo(newFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                movie.setFilmPic(fileName);
            }

        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie edit(int id, Movie movie) {
        Movie findMovie = movieRepository.findById(id);

        Movie updateMovie = Movie.builder()
                .name(movie.getName())
                .genre(movie.getGenre())
                .description(movie.getDescription())
                .movieCountry(movie.getMovieCountry())
                .primere(movie.getPrimere())
                .vieweing(movie.getVieweing())
                .filmVideo(movie.getFilmVideo())
                .filmTrailer(movie.getFilmTrailer())
                .yearOfIdssue(movie.getYearOfIdssue())
                .totalMovierate(movie.getTotalMovierate())
                .build();
        return movieRepository.save(updateMovie);
    }

    @Override
    public Movie getById(int id) {
        String username = userDetailService.getLoggedInUser().getName();
        log.info("User {} is trying get Movie id:{}", username, id);
        return movieRepository.findById(id);
    }

}
