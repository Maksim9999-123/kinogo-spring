package com.itspace.kinogospringrest.dto.user;

import com.itspace.kinogospringcommon.model.entity.Coutry;
import com.itspace.kinogospringcommon.model.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {
    private String name;
    private String surname;
    private Coutry coutry;
    private int age;
    private Gender gender;
    private String email;
    private String password;
}
