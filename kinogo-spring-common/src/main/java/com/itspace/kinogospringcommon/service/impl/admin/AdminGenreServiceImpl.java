package com.itspace.kinogospringcommon.service.impl.admin;

import com.itspace.kinogospringcommon.exception.GenreNotFoundException;
import com.itspace.kinogospringcommon.model.entity.Genre;
import com.itspace.kinogospringcommon.repository.GenreRepository;
import com.itspace.kinogospringcommon.security.UserDetailServiceImpl;
import com.itspace.kinogospringcommon.service.admin.AdminGenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.GENRE_NOT_FOUND;


/**
 * Implementation of {@link AdminGenreService} interface.
 * Wrapper for {@link GenreRepository} + business logic.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminGenreServiceImpl implements AdminGenreService {

    private final GenreRepository genreRepository;
    private final UserDetailServiceImpl userDetailService;

    @Override
    public void delete(int id) {
        int userId = userDetailService.getLoggedInUser().getId();
        if (!genreRepository.existsById(id)) {
            throw new GenreNotFoundException(GENRE_NOT_FOUND);
        }
        genreRepository.deleteById(id);
        log.info("User with id:{} deleted the Genre with id:{}", userId, id);
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
        log.info("Successfully saved new Genre in Data Base");
    }

    @Override
    public Genre edit(Genre genre, int id) {
        Genre oldGenre = genreRepository
                .findById(id)
                .orElseThrow(() -> new GenreNotFoundException(GENRE_NOT_FOUND));
        log.info("Trying to update genre entity");
        if (genre.getName() != null) {
            oldGenre.setName(genre.getName());
        }
        log.info("Successfully update cast & crew entity");
        return genreRepository.save(oldGenre);
    }

    @Override
    public Genre getById(int id) {
        String username = userDetailService.getLoggedInUser().getName();
        log.info("User {} is trying get CastCrew item id:{}", username, id);
        return genreRepository.findById(id)
                .orElseThrow(()-> new GenreNotFoundException(GENRE_NOT_FOUND));
    }
}
