package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.repository.specification.CastCrewCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CastCrewRepository extends JpaRepository<CastCrew, Integer>, JpaSpecificationExecutor<CastCrew>, CastCrewCustomRepository {

    List<CastCrew> findAllById(int id);

    List<CastCrew> findTop20ByOrderByIdDesc();

    List<CastCrew> findAll();
}
