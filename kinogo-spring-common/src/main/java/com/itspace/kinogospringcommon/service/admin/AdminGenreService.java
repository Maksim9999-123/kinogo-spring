package com.itspace.kinogospringcommon.service.admin;

import com.itspace.kinogospringcommon.model.entity.Genre;

/**
 * Service interface for class {@link AdminGenreService}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface AdminGenreService {

    void delete(int id);
    void save(Genre genre);
    Genre edit(Genre genre, int id);

    Genre getById(int id);
}
