package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.Rated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatedRepository extends JpaRepository<Rated, Integer> {
}
