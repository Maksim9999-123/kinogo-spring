package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.service.CastCrewService;
import com.itspace.kinogospringcommon.service.GenreService;
import com.itspace.kinogospringcommon.service.MovieService;
import com.itspace.kinogospringrest.dto.CastCrewResponseDto;
import com.itspace.kinogospringrest.dto.GenreResponseDto;
import com.itspace.kinogospringrest.dto.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kinogo")
public class MainEndPoint {
    private final MovieService movieService;
    private final GenreService genreService;
    private final CastCrewService castCrewService;

//    @GetMapping()
//    public List<MovieResponseDto, GenreResponseDto, CastCrewResponseDto> mainPage(){
//
//    }
}
