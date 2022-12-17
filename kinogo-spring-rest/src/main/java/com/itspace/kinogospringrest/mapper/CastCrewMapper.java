package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.CastCrew;
import com.itspace.kinogospringrest.dto.respons.CastCrewResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CastCrewMapper {

    CastCrew map(CastCrewCreateDto castCrewCreateDto);
    CastCrewResponseDto map(CastCrew castCrew);
    List<CastCrewResponseDto> map(List<CastCrew> castCrewList);
}
