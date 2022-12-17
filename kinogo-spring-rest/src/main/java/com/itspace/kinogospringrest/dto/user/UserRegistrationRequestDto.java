package com.itspace.kinogospringrest.dto.user;

import com.itspace.kinogospringrest.validation.constraint.Name;
import com.itspace.kinogospringrest.validation.constraint.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationRequestDto {

    @Name
    private String name;
    @Name
    private String surname;
    @Email
    private String email;
    @Positive
    private int age;
    @Password
    private String password;
}
