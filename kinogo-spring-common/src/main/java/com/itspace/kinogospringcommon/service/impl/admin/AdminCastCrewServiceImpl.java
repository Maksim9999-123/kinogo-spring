package com.itspace.kinogospringcommon.service.impl.admin;

import com.itspace.kinogospringcommon.model.entity.CastCrew;
import com.itspace.kinogospringcommon.repository.CastCrewRepository;
import com.itspace.kinogospringcommon.service.admin.AdminCastCrewService;
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
