package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.FilmComment;
import com.itspace.kinogospringrest.dto.FilmCommentCreateDto;
import com.itspace.kinogospringrest.dto.FilmCommentResponseDto;
import com.itspace.kinogospringrest.dto.FilmCommentUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmCommentMapper {
    FilmComment map(FilmCommentCreateDto filmCommentCreateDto);
    FilmComment map(FilmCommentUpdateDto filmCommentUpdateDto);

    FilmCommentResponseDto map(FilmComment filmComment);

    List<FilmCommentResponseDto> map(List<FilmComment> all);

}
