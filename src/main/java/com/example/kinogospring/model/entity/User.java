package com.example.kinogospring.model.entity;

import com.example.kinogospring.model.enums.Coutry;
import com.example.kinogospring.model.enums.Role;
import com.example.kinogospring.model.enums.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 18, message = "Name should be between 4 and 18 character")
    private String name;

    @NotEmpty(message = "surName should not be empty")
    @Size(min = 4, max = 20, message = "surName should be between 4 and 20 character")
    private String surname;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Coutry coutry;

    @Min(value = 16, message = "Age should be greater than 16")
    @Positive(message = "Age can`t be smaller than 0")
    private int age;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @NotEmpty
    private Role role;
    private boolean isEnabled;
    private String verifyToken;
    @Enumerated(value = EnumType.STRING)
    @NotEmpty
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
