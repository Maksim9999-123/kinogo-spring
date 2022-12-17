package com.itspace.kinogospringrest.dto.request;

import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatedRequestDto {

    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;
    @Size(min = 1, max = 5, message = "Name should be between 1 and 5 character")
    private int rate;
}
