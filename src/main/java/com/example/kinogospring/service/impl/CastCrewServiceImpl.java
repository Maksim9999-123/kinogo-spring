package com.example.kinogospring.service.impl;

import com.example.kinogospring.exception.EntityNotFoundException;
import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.service.CastCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CastCrewServiceImpl implements CastCrewService {

    private final CastCrewRepository castCrewRepository;


    @Override
    public List<CastCrew> getAll() {
        return castCrewRepository.findAll();
    }

    @Override
    public Optional<CastCrew> getById(int id) {
        return castCrewRepository.findById(id);
    }

    @Override
    public List<CastCrew> findAllById(int id) throws EntityNotFoundException {
        List<CastCrew> allById = castCrewRepository.findAllById(id);
        if(allById.isEmpty()){
            throw new EntityNotFoundException("No cast and crew content for this id " + id);
        }
        return allById;
    }

    @Override
    public List<CastCrew> findTop20ByOrderByIdDesc() {
        return castCrewRepository.findTop20ByOrderByIdDesc();
    }

    @Override
    public int count() {
        return (int) castCrewRepository.count();
    }
}
