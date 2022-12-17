package com.itspace.kinogospringrest.dto.respons;

import com.itspace.kinogospringcommon.model.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmCommentResponseDto {
    private String comment;
    @ManyToOne
    private Movie movie;
}
