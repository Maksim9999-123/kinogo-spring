package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link User}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface UserRepository extends JpaRepository<User,Integer> {


   Optional<User>  findByEmail(String email);
    boolean existsUserByEmail(String email);

    Optional<User> findByEmailAndVerifyToken(String email, String token);

}
