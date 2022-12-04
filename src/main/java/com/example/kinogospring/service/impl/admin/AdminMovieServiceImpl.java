package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.model.entity.Movie;
import com.example.kinogospring.repository.MovieRepository;
import com.example.kinogospring.service.adminservice.AdminMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminMovieServiceImpl implements AdminMovieService {


    private final MovieRepository movieRepository;

    @Value("${kinogo.spring.images.folder}")
    private String folderPathImage;

    @Value("${kinogo.spring.videos.folder}")
    private String folderPathVideos;

    @Override
    public void delete(int id) {
        movieRepository.deleteById(id);
    }
    @Override
    public void save(Movie movie, MultipartFile[] files) {
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
        movieRepository.save(movie);
    }

    @Override
    public String edit(Movie movie) {
        return null;
    }

    @Override
    public Optional<Movie> getById(int id) {
        return movieRepository.findById(id);
    }
}
