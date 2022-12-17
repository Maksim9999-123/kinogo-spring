package com.itspace.kinogospringrest.dto.respons;

import com.itspace.kinogospringcommon.model.entity.Zodiac;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CastCrewResponseDto {
    private String name;
    private String career;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Zodiac zodiac;
}
