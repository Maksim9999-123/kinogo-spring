package com.example.kinogospring.model.entity;

import com.example.kinogospring.model.enums.Coutry;
import com.example.kinogospring.model.enums.Role;
import com.example.kinogospring.model.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
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
    @Enumerated(value = EnumType.STRING)
    private Gender gender;


}
