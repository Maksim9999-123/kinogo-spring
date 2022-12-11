package com.itspace.kinogospringcommon.service;


import com.itspace.kinogospringcommon.model.entity.Rated;

public interface RatedService {
    void saveRate(Rated rate, int movieId);

}
