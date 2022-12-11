package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.exception.BadRequestException;
import com.itspace.kinogospringcommon.model.entity.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll() throws BadRequestException;
}
