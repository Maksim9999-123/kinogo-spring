package com.example.kinogospring.model.entity;

import com.example.kinogospring.model.enums.CastCrewRole;
import com.example.kinogospring.model.enums.Zodiac;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cast_crew")
public class CastCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String career;
    private double height;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date dateBirth;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Zodiac zodiac;
    private String genre;
    private int totalFilm;
    private Date firstFilm;
    private Date latestFilm;
    @Enumerated(value = EnumType.STRING)
    private CastCrewRole castCrewRole;
    private String profilPic;
    private String biography;
    @ManyToOne
    private Movie movie;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastCrew castCrew = (CastCrew) o;
        return id == castCrew.id && Double.compare(castCrew.height, height) == 0 && age == castCrew.age && totalFilm == castCrew.totalFilm && Objects.equals(name, castCrew.name) && Objects.equals(career, castCrew.career) && Objects.equals(dateBirth, castCrew.dateBirth) && zodiac == castCrew.zodiac && Objects.equals(genre, castCrew.genre) && Objects.equals(firstFilm, castCrew.firstFilm) && Objects.equals(latestFilm, castCrew.latestFilm) && castCrewRole == castCrew.castCrewRole && Objects.equals(profilPic, castCrew.profilPic) && Objects.equals(biography, castCrew.biography) && Objects.equals(movie, castCrew.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, career, height, dateBirth, age, zodiac, genre, totalFilm, firstFilm, latestFilm, castCrewRole, profilPic, biography, movie);
    }
}
