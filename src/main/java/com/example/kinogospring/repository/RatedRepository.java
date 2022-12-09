package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.Rated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatedRepository extends JpaRepository<Rated, Integer> {
}
