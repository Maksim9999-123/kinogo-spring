package com.itspace.kinogospringcommon.service.impl;

import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.exception.ErrorHandler;
import com.itspace.kinogospringcommon.model.entity.CastCrew;
import com.itspace.kinogospringcommon.repository.CastCrewRepository;
import com.itspace.kinogospringcommon.service.CastCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.USER_NOT_FOUND;

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
            throw new EntityNotFoundException(USER_NOT_FOUND);
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
