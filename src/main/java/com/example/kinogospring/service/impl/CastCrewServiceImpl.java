package com.example.kinogospring.service.impl;

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
    public List<CastCrew> findAllById(int id) {
        return castCrewRepository.findAllById(id);
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
