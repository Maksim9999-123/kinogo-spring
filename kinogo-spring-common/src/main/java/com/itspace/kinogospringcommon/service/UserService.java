package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.exception.DuplicateResourceException;
import com.itspace.kinogospringcommon.model.entity.User;

import javax.mail.MessagingException;
import java.util.Optional;

public interface UserService {

    void save(User user) throws DuplicateResourceException, MessagingException;
    void verifyUser(String email, String token) throws Exception;

    Optional<User> findByEmail(String email);

    public User update(User user);



}
