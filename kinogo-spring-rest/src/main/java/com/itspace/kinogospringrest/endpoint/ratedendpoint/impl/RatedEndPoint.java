package com.itspace.kinogospringrest.endpoint.ratedendpoint.impl;


import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.RatedService;
import com.itspace.kinogospringrest.dto.request.RatedRequestDto;
import com.itspace.kinogospringrest.endpoint.ratedendpoint.RatedApp;
import com.itspace.kinogospringrest.mapper.RatedMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * REST controller for rate requests.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rateds")
public class RatedEndPoint implements RatedApp {

    private final RatedService ratedService;
    private final RatedMapper ratedMapper;

    private final UserDetailServiceImpl userDetailsService;

    @PostMapping("/movie/{id}")
    public ResponseEntity<Rated> rateMovie(@Valid @RequestBody RatedRequestDto ratedRequestDto,
                                           @PathVariable("id") int movieId) {
        int userId = userDetailsService.getLoggedInUser().getId();
        log.info("Try to rate movie by user with id: {}",userId);
        Rated rated = ratedService.saveRate(ratedMapper.mapToEntity(ratedRequestDto), movieId);
        return ResponseEntity.ok(rated);
    }
}
