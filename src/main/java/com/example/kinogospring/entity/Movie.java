package com.example.kinogospring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int totalMovierate;
    @Enumerated(value = EnumType.STRING)
    private MovieCountry movieCountry;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date yearOfIdssue;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date primere;
    private String description;
    private String filmPic;
    private int vieweing;
    private String filmVideo;
    @OneToMany
    private List<Genre> genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && totalMovierate == movie.totalMovierate && vieweing == movie.vieweing && Objects.equals(name, movie.name) && movieCountry == movie.movieCountry && Objects.equals(yearOfIdssue, movie.yearOfIdssue) && Objects.equals(primere, movie.primere) && Objects.equals(description, movie.description) && Objects.equals(filmPic, movie.filmPic) && Objects.equals(filmVideo, movie.filmVideo) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalMovierate, movieCountry, yearOfIdssue, primere, description, filmPic, vieweing, filmVideo, genre);
    }
}
