package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.exception.BadRequestException;
import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.service.GenreService;
import com.itspace.kinogospringrest.dto.GenreResponseDto;
import com.itspace.kinogospringrest.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kinogo")
public class GenreEndPoint {
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @GetMapping("/genre")
    public List<GenreResponseDto> getAllGenres() throws BadRequestException {
        return genreMapper.map(genreService.findAll());
    }
    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") int id){
        Optional<Genre> genreById = genreService.findById(id);
        if(genreById.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genreById.get());
    }
}
