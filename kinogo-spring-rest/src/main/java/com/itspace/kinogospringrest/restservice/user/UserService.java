package com.itspace.kinogospringrest.restservice.user;

import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringrest.dto.user.ChangePasswordRequestDto;
import com.itspace.kinogospringrest.dto.user.EditUserDto;

/**
 * Service interface for class {@link User}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface UserService {
    User edit(int id, EditUserDto editUserDto);
    User findUserById(int id);
    User getCurrentUser();
    void changePassword(ChangePasswordRequestDto changePasswordRequestDto);
}
