package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.service.adminservice.AdminCastCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminCastCrewServiceImpl implements AdminCastCrewService {

    private final CastCrewRepository castCrewRepository;

    @Override
    public void delete(int id) {
        castCrewRepository.deleteById(id);
    }

    @Override
    public void save(CastCrew castCrew) {
        castCrewRepository.save(castCrew);
    }

    @Override
    public String edit(CastCrew castCrew) {
        return null;
    }

    @Override
    public Optional getById(int id) {
        return castCrewRepository.findById(id);
    }
}
