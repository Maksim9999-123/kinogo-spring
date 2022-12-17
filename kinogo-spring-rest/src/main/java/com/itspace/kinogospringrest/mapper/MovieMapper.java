package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringrest.dto.request.CreateMovieRequestDto;
import com.itspace.kinogospringrest.dto.respons.MovieResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieResponseDto mapToResponseDto(Movie movie);

    List<MovieResponseDto> mapToResponseList(List<Movie> movieList);

    Movie mapToEntity(CreateMovieRequestDto createMovieRequestDto);

    CreateMovieRequestDto mapToRequestDto(Movie movie);
}
