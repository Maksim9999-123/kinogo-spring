package com.example.kinogospring.service;


import com.example.kinogospring.model.entity.Rated;

public interface RatedService {
    void saveRate(Rated rate, int movieId);

}
