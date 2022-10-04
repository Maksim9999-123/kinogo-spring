package com.example.kinogospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rated")
public class Rated {
    @Id
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    private int rate;
}
