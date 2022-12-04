package com.example.kinogospring.model.entity;

import com.example.kinogospring.model.enums.Coutry;
import com.example.kinogospring.model.enums.Role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && isEnabled == user.isEnabled && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && coutry == user.coutry && Objects.equals(password, user.password) && role == user.role && Objects.equals(verifyToken, user.verifyToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, coutry, age, password, role, isEnabled, verifyToken);
    }
}
