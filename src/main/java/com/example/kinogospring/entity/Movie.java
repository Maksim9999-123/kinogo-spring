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
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int totalMovierate;
    @Enumerated(value = EnumType.STRING)
    private MovieCountry movieCountry;
    private Date yearOfIdssue;
    private Date primere;
    private String description;
    private String filmPic;
    private int vieweing;
    @ManyToOne
    private Genre genre;
}
