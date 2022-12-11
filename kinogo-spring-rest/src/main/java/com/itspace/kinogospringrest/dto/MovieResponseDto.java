package com.itspace.kinogospringrest.dto;

import com.itspace.kinogospringcommon.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDto {
    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Data primere;
    private String filmPic;
    private String filmVideo;
    private List<Genre> genre;

}
