package com.itspace.kinogospringrest.dto.user;

import com.itspace.kinogospringrest.validation.constraint.Name;
import com.itspace.kinogospringrest.validation.constraint.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

    @Name
    private String username;
    @Password
    private String password;

}
