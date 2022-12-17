package com.itspace.kinogospringcommon.service.impl;


import com.itspace.kinogospringcommon.exception.DuplicateEmailResourceException;
import com.itspace.kinogospringcommon.exception.UserNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Role;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.repository.UserRepository;
import com.itspace.kinogospringcommon.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
    private final MailServiceImpl mailService;
    private final PasswordEncoder passwordEncoder;


    public void save(User user){
        validateEmail(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.USER);
        user.setEnabled(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);

        mailService.sendHtmlEmail(user.getEmail(), "Please verify your email", "Hi " + user.getName() + "\n" +
                "Please verify your account by clicking on this link " +
                "<a href=http://localhost:8081/user/verify?email=" + user.getEmail() + "&token=" + user.getVerifyToken());
    }

    public void verifyUser(String email, String token) {
        Optional<User> userOptional = userRepository.findByEmailAndVerifyToken(email, token);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        User user = userOptional.get();
        if (user.isEnabled()) {
            throw new UserNotFoundException(REFRESH_TOKEN_EXPIRED);
        }
        user.setEnabled(true);
        user.setVerifyToken(null);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    private void validateEmail(User user){
        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new DuplicateEmailResourceException(USER_ALREADY_EXIST_WITH_EMAIL);
        }
    }

}
