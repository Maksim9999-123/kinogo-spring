package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Genre}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
