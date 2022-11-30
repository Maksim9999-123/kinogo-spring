package com.example.kinogospring.service.impl.admin;

import com.example.kinogospring.entity.CastCrew;
import com.example.kinogospring.repository.CastCrewRepository;
import com.example.kinogospring.service.adminservice.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminCastCrewServiceImpl implements AdminService<CastCrew> {


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
}
