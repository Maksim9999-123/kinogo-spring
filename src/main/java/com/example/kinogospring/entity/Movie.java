package com.example.kinogospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
}
