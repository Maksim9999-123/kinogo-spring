package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.model.entity.User;

/**
 * Service interface for class {@link User}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */

public interface UserService {

    void save(User user);
    void verifyUser(String email, String token);

    User findByEmail(String email);

    User update(User user);



}
