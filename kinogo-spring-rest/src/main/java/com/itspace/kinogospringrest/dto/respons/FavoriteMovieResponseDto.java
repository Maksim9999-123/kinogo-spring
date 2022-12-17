package com.itspace.kinogospringrest.dto.respons;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteMovieResponseDto {
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;
}
