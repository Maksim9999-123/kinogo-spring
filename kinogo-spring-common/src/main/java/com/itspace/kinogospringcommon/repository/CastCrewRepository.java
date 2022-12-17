package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.CastCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
/**
 * Repository interface that extends {@link JpaRepository} for class {@link CastCrew}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface CastCrewRepository extends JpaRepository<CastCrew, Integer>, JpaSpecificationExecutor<CastCrew> {

    List<CastCrew> findAllById(int id);

    List<CastCrew> findTop20ByOrderByIdDesc();

    List<CastCrew> findAll();
}
