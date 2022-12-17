package com.itspace.kinogospringcommon.service;

import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.CastCrew;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for class {@link CastCrew}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

public interface CastCrewService {

    List<CastCrew> getAll();

    Optional<CastCrew> getById(int id);
    List<CastCrew> findAllById(int id) throws EntityNotFoundException;
    List<CastCrew> findTop20ByOrderByIdDesc();
    int count();

}
