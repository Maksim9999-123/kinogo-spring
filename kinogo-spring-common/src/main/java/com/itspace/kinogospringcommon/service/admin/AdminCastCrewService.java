package com.itspace.kinogospringcommon.service.admin;

import com.itspace.kinogospringcommon.model.entity.CastCrew;

import java.util.Optional;

public interface AdminCastCrewService {


    void delete(int id);
    void save(CastCrew castCrew);
    String edit(CastCrew castCrew);

    Optional<CastCrew> getById(int id);
}
