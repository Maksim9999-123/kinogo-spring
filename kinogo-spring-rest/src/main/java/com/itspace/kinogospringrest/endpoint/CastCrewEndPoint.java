package com.itspace.kinogospringrest.endpoint;

import com.itspace.kinogospringcommon.model.entity.CastCrew;
import com.itspace.kinogospringcommon.service.CastCrewService;
import com.itspace.kinogospringcommon.service.admin.AdminCastCrewService;
import com.itspace.kinogospringrest.dto.respons.CastCrewResponseDto;
import com.itspace.kinogospringrest.mapper.CastCrewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/castAndCrew")
@Log4j2
public class CastCrewEndPoint {
    private final CastCrewService castCrewService;
    private final AdminCastCrewService adminCastCrewService;
    private final CastCrewMapper castCrewMapper;

    @GetMapping
    public List<CastCrewResponseDto> getAllCastCrew(){
        log.info("Called entity cast and crew");
        return castCrewMapper.map(castCrewService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCastCrewById(@PathVariable int id){
        CastCrew castCrew = adminCastCrewService.getById(id);
        log.info("Called entity cast and crew by id");
        return ResponseEntity.ok(castCrewMapper.map(castCrew));
    }

    @PostMapping
    public ResponseEntity<CastCrew> createCastCrew(@RequestBody CastCrewCreateDto castCrewCreateDto){
        CastCrew castCrew = adminCastCrewService.save(castCrewMapper.map(castCrewCreateDto));
        log.info("Called entity cast and crew for create data");
        return ResponseEntity.status(HttpStatus.CREATED).body(castCrew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CastCrew> updateCastCrew(@PathVariable int id, @RequestBody CastCrewCreateDto castCrewCreateDto){
        log.info("Called entity cast and crew for update data by id");
        return ResponseEntity.ok(adminCastCrewService.edit(id, castCrewMapper.map(castCrewCreateDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCastCrew(@PathVariable int id){
        adminCastCrewService.delete(id);
        log.info("Called entity cast and crew for delete data by id");
        return ResponseEntity.ok().build();
    }
}
