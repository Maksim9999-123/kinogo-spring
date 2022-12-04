package com.example.kinogospring.repository;

import com.example.kinogospring.model.entity.Rated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatedRepository extends JpaRepository<Rated, Integer> {
}
