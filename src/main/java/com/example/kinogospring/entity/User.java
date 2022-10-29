package com.example.kinogospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Coutry coutry;
    private int age;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private boolean isEnabled;
    private String verifyToken;
}
