package com.example.kinogospring.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "film_comment")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;

}
