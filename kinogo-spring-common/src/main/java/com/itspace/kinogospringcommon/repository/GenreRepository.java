package com.itspace.kinogospringcommon.repository;

import com.itspace.kinogospringcommon.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
