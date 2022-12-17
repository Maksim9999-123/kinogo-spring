package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.exception.BadRequestException;
import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.service.GenreService;
import com.itspace.kinogospringcommon.service.admin.AdminGenreService;
import com.itspace.kinogospringrest.dto.respons.GenreResponseDto;
import com.itspace.kinogospringrest.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/v1/kinogo")
public class GenreEndPoint {
    private final GenreService genreService;
    private final AdminGenreService adminGenreService;
    private final GenreMapper genreMapper;
    @GetMapping
    public List<GenreResponseDto> getAllGenres() throws BadRequestException {
        log.info("Called entity genre");
        return genreMapper.map(genreService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable("id") int id) throws EntityNotFoundException {
        Genre genre = genreService.findById(id);
        log.info("Called entity genre by id");
        return ResponseEntity.ok(genreMapper.map(genre));
    }
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody GenreCreateDto genreCreateDto){
        Genre genre = adminGenreService.save(genreMapper.map(genreCreateDto));
        log.info("Called entity for create genre.");
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable int id, @RequestBody GenreCreateDto genreCreateDto) throws EntityNotFoundException {
        log.info("Called entity for update genre data by id");
        return ResponseEntity.ok(adminGenreService.edit(id, genreMapper.map(genreCreateDto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable int id){
        adminGenreService.delete(id);
        log.info("Called entity for delete genre by id");
        return ResponseEntity.ok().build();
    }
}
