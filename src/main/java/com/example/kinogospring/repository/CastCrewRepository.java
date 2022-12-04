package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.CastCrew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CastCrewRepository extends JpaRepository<CastCrew,Integer> {

    List<CastCrew> findAllById(int id);
    List<CastCrew> findTop20ByOrderByIdDesc();

}
