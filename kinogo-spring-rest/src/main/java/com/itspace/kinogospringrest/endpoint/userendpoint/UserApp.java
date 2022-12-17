package com.itspace.kinogospringrest.endpoint.userendpoint;

import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringrest.dto.user.ChangePasswordRequestDto;
import com.itspace.kinogospringrest.dto.user.EditUserDto;
import com.itspace.kinogospringrest.endpoint.userendpoint.impl.UserEndPoint;
import com.itspace.kinogospringrest.restservice.userdetails.CurrentUserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserApp interface for class {@link UserEndPoint}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface UserApp {

    ResponseEntity<User> getById(int id, UserDetails user);

    ResponseEntity<User> editUser(int id, CurrentUserDetails user, EditUserDto editUserDto);

    ResponseEntity<User> getCurrentUser();

    ResponseEntity<?> changePassword(ChangePasswordRequestDto changePasswordRequestDto);
}
