package com.itspace.kinogospringcommon.repository.querydsl;

import com.itspace.kinogospringcommon.model.entity.CastCrew;

import java.util.List;

public interface CastCrewDao {

    List<CastCrew> findCastCrewByNameQueryDSL(String firstname);

    List<CastCrew> findCastCrewsByNameAndAgeQueryDSL(String firstname, int age);


}
