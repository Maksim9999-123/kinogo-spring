package com.example.kinogospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cast_creq")
public class CastCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String career;
    private double height;
    private Date dateBirth;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Zodiac zodiac;
    private String genre;
    private int totalFilms;
    private Date firstFilm;
    private Date latestFilm;
    @ManyToOne
    private Actor actor;
    @ManyToOne
    private Producer producer;
    @ManyToOne
    private Movie movie;
}
