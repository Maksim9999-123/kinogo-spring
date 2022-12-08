package com.example.kinogospring.service;

import com.example.kinogospring.exception.DuplicateResourceException;
import com.example.kinogospring.model.entity.User;

import javax.mail.MessagingException;
import java.util.Optional;

public interface UserService {

    void save(User user) throws DuplicateResourceException, MessagingException;
    void verifyUser(String email, String token) throws Exception;

    Optional<User> findByEmail(String email);

    public User update(User user);



}
