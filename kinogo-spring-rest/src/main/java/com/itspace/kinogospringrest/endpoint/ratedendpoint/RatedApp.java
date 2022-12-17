package com.itspace.kinogospringrest.endpoint.ratedendpoint;

import com.itspace.kinogospringcommon.model.entity.Rated;
import com.itspace.kinogospringrest.dto.request.RatedRequestDto;
import com.itspace.kinogospringrest.endpoint.ratedendpoint.impl.RatedEndPoint;
import org.springframework.http.ResponseEntity;

/**
 * RatedApp interface for class {@link RatedEndPoint}.
 *
 * @author Maksim Aslanyan
 * @version 1.0
 */
public interface RatedApp {

    ResponseEntity<Rated> rateMovie(RatedRequestDto ratedRequestDto, int movieId);
}
