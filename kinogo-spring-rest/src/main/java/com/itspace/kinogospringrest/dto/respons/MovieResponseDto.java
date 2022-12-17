package com.itspace.kinogospringrest.dto.respons;

import com.itspace.kinogospringcommon.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDto {

    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date primere;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date yearOfIdssue;
    private String filmPic;
    private String filmVideo;
    private List<Genre> genre;

}
