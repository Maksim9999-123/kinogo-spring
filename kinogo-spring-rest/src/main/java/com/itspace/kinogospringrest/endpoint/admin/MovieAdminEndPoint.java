package com.itspace.kinogospringrest.endpoint.admin;


import com.itspace.kinogospringcommon.model.entity.Movie;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.admin.AdminMovieService;
import com.itspace.kinogospringrest.dto.request.CreateMovieRequestDto;
import com.itspace.kinogospringrest.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * REST controller for admin Movie requests.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/movies")
public class MovieAdminEndPoint {

    private final AdminMovieService adminMovieService;
    private final MovieMapper movieMapper;
    private final UserDetailServiceImpl currentUser;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody CreateMovieRequestDto createMovieRequestDto,
                                             @RequestParam MultipartFile[] files) {
        int userid = currentUser.getLoggedInUser().getId();
        Movie movie = adminMovieService.save(movieMapper.mapToEntity(createMovieRequestDto), files);
        log.info("Try to create new Movie:{} by admin with id:{}", createMovieRequestDto.getName(),
                userid);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id,
                                             @Valid @RequestBody CreateMovieRequestDto createMovieRequestDto) {
        int userid = currentUser.getLoggedInUser().getId();
        log.info("Try to update Movie:by admin with id:{}", userid);
        return ResponseEntity.ok(adminMovieService.edit(id, movieMapper.mapToEntity(createMovieRequestDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) {
        int userid = currentUser.getLoggedInUser().getId();
        log.info("Try to delete Movie:by admin with id:{}", userid);
        adminMovieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
