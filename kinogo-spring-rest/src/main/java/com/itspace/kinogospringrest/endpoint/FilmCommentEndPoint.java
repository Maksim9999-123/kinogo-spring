package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.exception.EntityNotFoundException;
import com.itspace.kinogospringcommon.model.entity.FilmComment;
import com.itspace.kinogospringcommon.service.CommentMovieService;
import com.itspace.kinogospringcommon.service.admin.AdminFilmCommentService;
import com.itspace.kinogospringrest.dto.FilmCommentCreateDto;
import com.itspace.kinogospringrest.dto.FilmCommentResponseDto;
import com.itspace.kinogospringrest.dto.FilmCommentUpdateDto;
import com.itspace.kinogospringrest.dto.respons.FilmCommentResponseDto;
import com.itspace.kinogospringrest.mapper.FilmCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmComment")
public class FilmCommentEndPoint {
    private final CommentMovieService commentMovieService;

    private final FilmCommentMapper filmCommentMapper;

    private final AdminFilmCommentService adminFilmCommentService;

    @GetMapping()
    public List<FilmCommentResponseDto> getAllFilmComment(){
        return filmCommentMapper.map(commentMovieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmCommentById(@PathVariable int id){
        FilmComment filmComment = commentMovieService.getById(id);
        return ResponseEntity.ok(filmCommentMapper.map(filmComment));
    }

    @PostMapping()
    public ResponseEntity<FilmComment> createFilmComment(@RequestBody FilmCommentCreateDto filmCommentCreateDto){
        return ResponseEntity.ok(adminFilmCommentService.save(filmCommentMapper.map(filmCommentCreateDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmComment> updateFilmComment(@PathVariable int id, @RequestBody FilmCommentUpdateDto filmCommentUpdateDto) throws EntityNotFoundException {
        return ResponseEntity.ok(adminFilmCommentService.edit(id, filmCommentMapper.map(filmCommentUpdateDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilmComment(@PathVariable int id){
        adminFilmCommentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
