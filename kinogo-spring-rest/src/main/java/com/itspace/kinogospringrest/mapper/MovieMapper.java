package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringrest.dto.MovieResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieResponseDto map(Movie movie);
    List<MovieResponseDto> map(List<Movie> movieList);
}
