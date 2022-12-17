package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringrest.dto.FavoriteMovieResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavoriteMovieMapper {
    FavoriteMovieResponseDto map(FavoriteMovie favoriteMovie);
    List<FavoriteMovieResponseDto> map(List<FavoriteMovie> favoriteMovieList);
}
