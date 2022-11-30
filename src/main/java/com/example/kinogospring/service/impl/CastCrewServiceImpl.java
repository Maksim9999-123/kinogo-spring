package com.example.kinogospring.service.impl;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CastCrewServiceImpl implements GetService<CastCrew> {

    private final CastCrewRepository castCrewRepository;


    @Override
    public List<CastCrew> getAll() {
        return castCrewRepository.findAll();
    }

    @Override
    public Optional<CastCrew> getById(int id) {
        return castCrewRepository.findById(id);
    }
}
