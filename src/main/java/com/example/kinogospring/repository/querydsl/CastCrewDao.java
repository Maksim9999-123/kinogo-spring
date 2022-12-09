package com.example.kinogospring.repository.querydsl;

import com.example.kinogospring.model.entity.CastCrew;

import java.util.List;

public interface CastCrewDao {

    List<CastCrew> findCastCrewByNameQueryDSL(String firstname);

    List<CastCrew> findCastCrewsByNameAndAgeQueryDSL(String firstname, int age);


}
