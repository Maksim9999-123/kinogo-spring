package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringrest.dto.request.RatedRequestDto;
import org.mapstruct.Mapper;

/**
 * Mapper interface for map objects.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface RatedMapper {

    Rated mapToEntity(RatedRequestDto createRatedRequestDto);
}
