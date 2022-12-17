package com.itspace.kinogospringcommon.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && isEnabled == user.isEnabled && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && coutry == user.coutry && Objects.equals(password, user.password) && role == user.role && Objects.equals(verifyToken, user.verifyToken) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, coutry, age, password, role, isEnabled, verifyToken, gender);
    }
}
