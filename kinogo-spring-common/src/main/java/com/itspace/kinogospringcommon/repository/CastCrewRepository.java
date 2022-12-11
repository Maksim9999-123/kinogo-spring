package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.CastCrew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CastCrewRepository extends JpaRepository<CastCrew, Integer>, JpaSpecificationExecutor<CastCrew> {

    List<CastCrew> findAllById(int id);

    List<CastCrew> findTop20ByOrderByIdDesc();

    List<CastCrew> findAll();
}
