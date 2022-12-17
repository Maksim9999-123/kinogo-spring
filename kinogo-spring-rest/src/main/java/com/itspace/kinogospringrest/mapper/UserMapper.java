package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringrest.dto.user.UserRegistrationRequestDto;
import org.mapstruct.Mapper;

/**
 * Mapper interface for map objects.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    User maoToEntity(UserRegistrationRequestDto userRegistrationRequestDto);

}
