package com.itspace.kinogospringcommon.service.impl;


import com.itspace.kinogospringcommon.model.entity.Role;
import com.itspace.kinogospringcommon.model.entity.User;
import com.itspace.kinogospringcommon.exception.DuplicateResourceException;
import com.itspace.kinogospringcommon.repository.UserRepository;
import com.itspace.kinogospringcommon.service.UserService;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MailServiceImpl mailService;
    private final PasswordEncoder passwordEncoder;


    public void save(User user) throws DuplicateResourceException, MessagingException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateRequestException("User already exists!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.USER);
        user.setEnabled(false);
        user.setVerifyToken(UUID.randomUUID().toString());
        userRepository.save(user);
        mailService.sendHtmlEmail(user.getEmail(), "Please verify your email", "Hi " + user.getName() + "\n" +
                "Please verify your account by clicking on this link " +
                "<a href=http://localhost:8081/user/verify?email=" + user.getEmail() + "&token=" + user.getVerifyToken());
    }

    public void verifyUser(String email, String token) throws Exception {
        Optional<User> userOptional = userRepository.findByEmailAndVerifyToken(email, token);

        if (userOptional.isEmpty()) {
            throw new Exception("User Does not exists with email and token");
        }
        User user = userOptional.get();
        if (user.isEnabled()) {
            throw new Exception("User already enabled");
        }
        user.setEnabled(true);
        user.setVerifyToken(null);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }


//    @Override
//    public Optional<User> update(int id) {
//        return userRepository.save(id);
//    }

}
