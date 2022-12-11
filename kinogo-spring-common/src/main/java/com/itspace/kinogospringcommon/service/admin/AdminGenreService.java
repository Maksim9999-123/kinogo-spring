package com.itspace.kinogospringcommon.service.admin;

import com.itspace.kinogospringcommon.model.entity.Genre;

import java.util.Optional;

public interface AdminGenreService {

    void delete(int id);
    void save(Genre genre);
    String edit(Genre genre);

    Optional<Genre> getById(int id);
}
