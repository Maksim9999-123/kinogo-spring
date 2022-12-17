package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.FavoriteMovie;
import com.itspace.kinogospringcommon.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favoriteMovie")
public class FavoriteMovieEndPoint {
    private final FavoriteMovieMapper favoriteMovieMapper;
    private final FavoriteService favoriteService;

    @GetMapping()
    public List<FavoriteMovieResponseDto> getAllFavoriteMovie(){
        return favoriteMovieMapper.map(favoriteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFavoriteMovieById(@PathVariable int id) throws EntityNotFoundException {
        FavoriteMovie favoriteMovie = favoriteService.getById(id);
        return ResponseEntity.ok(favoriteMovieMapper.map(favoriteMovie));
    }
}
