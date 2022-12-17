package com.itspace.kinogospringrest.dto.request;

import com.itspace.kinogospringrest.validation.constraint.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreCreateDto {

    @Name
    private String name;
}
