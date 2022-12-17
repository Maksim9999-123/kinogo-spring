package com.itspace.kinogospringrest.restservice.user.impl;

import com.itspace.kinogospringcommon.exception.AuthenticationException;
import com.itspace.kinogospringcommon.exception.EmailAlreadyExistException;
import com.itspace.kinogospringcommon.exception.UserNotFoundException;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.UserRepository;
import com.itspace.kinogospringrest.dto.user.ChangePasswordRequestDto;
import com.itspace.kinogospringrest.dto.user.EditUserDto;
import com.itspace.kinogospringrest.restservice.impl.SecurityContextServiceImpl;
import com.itspace.kinogospringrest.restservice.user.UserService;
import com.itspace.kinogospringrest.restservice.userdetails.CurrentUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.*;

/**
 * Implementation of {@link UserService} interface.
 * Wrapper for {@link UserRepository} + business logic.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityContextServiceImpl securityContextService;
    private final PasswordEncoder passwordEncoder;

    public User edit(int id, EditUserDto editUserDto) {
        User user =
                userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        if (!user.getEmail().equalsIgnoreCase(editUserDto.getEmail())) {
            throw new EmailAlreadyExistException(USER_ALREADY_EXIST_WITH_EMAIL);
        }
        user.setName(editUserDto.getName());
        user.setSurname(editUserDto.getSurname());
        user.setEmail(editUserDto.getEmail());

        String oldEmail = user.getEmail();
        String newEmail = editUserDto.getEmail();

        if (!oldEmail.equalsIgnoreCase(newEmail)) {
            user.setEmail(newEmail);
        }
        return user;
    }

    public User findUserById(int id) {
        log.info("Request for get user by id");
        return userRepository
                .findById(id)
                .orElseThrow();
    }

    public User getCurrentUser() {
        CurrentUserDetails currentUser = securityContextService.getUserDetails();

        return userRepository
                .findById(currentUser.getId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }


    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
        String name = securityContextService.getUserDetails().getName();
        log.info("Request from user{}: for change password", name);
        User user = userRepository
                .findByEmail(name);
        if (user != null) {
            throw new AuthenticationException(USER_NOT_FOUND);
        }
        if (!isPasswordValidate(changePasswordRequestDto, user)) {
            log.warn("User {} provided wrong password for change", user.getEmail());
            throw new AuthenticationException(PROVIDED_WRONG_PASSWORD);
        }
        if (changePasswordRequestDto.getOldPassword().equals(changePasswordRequestDto.getNewPassword())) {
            log.warn("In change password request user{} provided the same password", user.getEmail());
            throw new AuthenticationException(PROVIDED_SAME_PASSWORD);
        }
        user.setPassword(passwordEncoder.encode(changePasswordRequestDto.getNewPassword()));
        log.info("User {} successfully changed password", user.getEmail());
    }

    private boolean isPasswordValidate(ChangePasswordRequestDto changePasswordRequestDto, User user) {
        return passwordEncoder.matches(changePasswordRequestDto.getOldPassword(), user.getPassword());
    }

}
