package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.Rated;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository interface that extends {@link JpaRepository} for class {@link Rated}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface RatedRepository extends JpaRepository<Rated, Integer> {
}
