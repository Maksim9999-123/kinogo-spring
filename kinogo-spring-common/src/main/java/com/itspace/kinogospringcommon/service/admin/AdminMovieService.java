package com.itspace.kinogospringcommon.service.admin;

import com.itspace.kinogospringcommon.model.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service interface for class {@link AdminMovieService}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface AdminMovieService {
    void delete(int id);

    Movie save(Movie movie, MultipartFile[] files);

    Movie edit(int id, Movie movie);

    Movie getById(int id);

}
