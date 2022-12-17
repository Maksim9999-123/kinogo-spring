package com.itspace.kinogospringcommon.service;


import com.itspace.kinogospringcommon.model.entity.Rated;

/**
 * Service interface for class {@link Rated}.
 *
 * @author Albert Nadoyan
 * @version 1.0
 */

public interface RatedService {
    Rated saveRate(Rated rate, int movieId);

}
