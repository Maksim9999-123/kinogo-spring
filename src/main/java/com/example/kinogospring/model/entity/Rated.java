package com.example.kinogospring.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rated")
public class Rated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    private int rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rated rated = (Rated) o;
        return id == rated.id && rate == rated.rate && Objects.equals(user, rated.user) && Objects.equals(movie, rated.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, movie, rate);
    }
}
