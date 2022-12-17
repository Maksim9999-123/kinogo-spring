package com.itspace.kinogospringcommon.service.impl.admin;

import com.itspace.kinogospringcommon.exception.CastCrewNotFoundException;
import com.itspace.kinogospringcommon.model.entity.CastCrew;
import com.itspace.kinogospringcommon.repository.CastCrewRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.admin.AdminCastCrewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.CAST_CREW_NOT_FOUND;

/**
 * Implementation of {@link AdminCastCrewService} interface.
 * Wrapper for {@link CastCrewRepository} + business logic.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminCastCrewServiceImpl implements AdminCastCrewService {

    private final CastCrewRepository castCrewRepository;
    private final UserDetailServiceImpl userDetailService;

    @Override
    public void delete(int id) {
        int userId = userDetailService.getLoggedInUser().getId();
        if (!castCrewRepository.existsById(id)) {
            throw new CastCrewNotFoundException(CAST_CREW_NOT_FOUND);
        }
        castCrewRepository.deleteById(id);
        log.info("User with id:{} deleted the CastCrew with id:{}", userId, id);
    }

    @Override
    public void save(CastCrew castCrew) {
        castCrewRepository.save(castCrew);
        log.info("Successfully saved new Cast & Crew in Data Base");
    }

    @Override
    public CastCrew edit(CastCrew castCrew, int id) {
        log.info("Trying to update cast & crew entity");
        CastCrew update = updateCastCrew(castCrew, id);
        log.info("Successfully update cast & crew entity");
        return castCrewRepository.save(update);
    }

    @Override
    public CastCrew getById(int id) {
        String username = userDetailService.getLoggedInUser().getName();
        log.info("User {} is trying get CastCrew item id:{}", username, id);
        return castCrewRepository
                .findById(id).orElseThrow(() -> new CastCrewNotFoundException(CAST_CREW_NOT_FOUND));
    }

    private CastCrew updateCastCrew(CastCrew castCrew, int id) {
        CastCrew oldCastCrew = castCrewRepository
                .findById(id)
                .orElseThrow(() -> new CastCrewNotFoundException(CAST_CREW_NOT_FOUND));

        if (castCrew.getBiography() != null) {
            oldCastCrew.setBiography(castCrew.getBiography());
        }
        if (castCrew.getGenre() != null) {
            oldCastCrew.setGenre(castCrew.getGenre());
        }
        if (castCrew.getCareer() != null) {
            oldCastCrew.setCareer(castCrew.getCareer());
        }
        if (castCrew.getName() != null) {
            oldCastCrew.setName(castCrew.getName());
        }
        if (castCrew.getZodiac() != null) {
            oldCastCrew.setZodiac(castCrew.getZodiac());
        }
        if (castCrew.getLatestFilm() != null) {
            oldCastCrew.setLatestFilm(castCrew.getLatestFilm());
        }
        return castCrewRepository.save(oldCastCrew);
    }
}
