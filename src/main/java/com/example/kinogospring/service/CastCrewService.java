package com.example.kinogospring.service;

import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.CastCrew;

import java.util.List;
import java.util.Optional;

public interface CastCrewService {

    List<CastCrew> getAll();

    Optional<CastCrew> getById(int id);
    List<CastCrew> findAllById(int id) throws EntityNotFoundException;
    List<CastCrew> findTop20ByOrderByIdDesc();
    int count();

}
