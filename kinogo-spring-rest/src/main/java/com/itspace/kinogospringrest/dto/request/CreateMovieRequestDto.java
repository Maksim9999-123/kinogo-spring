package com.itspace.kinogospringrest.dto.request;


import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.model.entity.MovieCountry;
import com.itspace.kinogospringrest.validation.constraint.Name;
import com.itspace.kinogospringrest.validation.constraint.NullOrNotEmptyList;
import com.itspace.kinogospringrest.validation.constraint.ValidFilmPic;
import com.itspace.kinogospringrest.validation.constraint.ValidVideo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMovieRequestDto {

    @Name
    private String name;
    @Positive
    private int totalMovieRate;
    @Enumerated(value = EnumType.STRING)
    private MovieCountry movieCountry;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date yearOfIdssue;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date primere;
    private String description;
    @ValidFilmPic
    private String filmPic;
    @Positive
    private int vieweing;
    @ValidVideo
    private String filmVideo;
    @ValidVideo
    private String filmTrailer;
    @Enumerated(value = EnumType.STRING)
    @OneToMany
    @NullOrNotEmptyList
    private List<Genre> genre;
}
