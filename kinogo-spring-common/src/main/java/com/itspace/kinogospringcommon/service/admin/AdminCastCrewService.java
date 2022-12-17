package com.itspace.kinogospringcommon.service.admin;

import com.itspace.kinogospringcommon.model.entity.CastCrew;

/**
 * Service interface for class {@link AdminCastCrewService}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */

public interface AdminCastCrewService {


    void delete(int id);

    void save(CastCrew castCrew);

    CastCrew edit(CastCrew castCrew, int id);

    CastCrew getById(int id);
}
