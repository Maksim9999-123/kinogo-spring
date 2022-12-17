package com.itspace.kinogospringrest.mapper;

import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringrest.dto.user.CreateUserDto;
import com.itspace.kinogospringrest.dto.user.UserDto;
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

    User map(CreateUserDto createUserDto);

    UserDto map(User user);

    User maoToEntity(UserRegistrationRequestDto userRegistrationRequestDto);

}
