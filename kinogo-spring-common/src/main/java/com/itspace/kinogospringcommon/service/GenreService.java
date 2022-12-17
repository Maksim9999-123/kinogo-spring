package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.exception.BadRequestException;
import com.itspace.kinogospringcommon.model.entity.Genre;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for class {@link Genre}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */
public interface GenreService {

    List<Genre> findAll() throws BadRequestException;
    Optional<Genre> findById(int id);
}
