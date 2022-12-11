package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringrest.dto.GenreResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreResponseDto map(Genre genre);
    List<GenreResponseDto> map(List<Genre> genreList);
}
