package com.itspace.kinogospringrest.dto.user;

import com.itspace.kinogospringrest.validation.constraint.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestDto {

    @Password
    private String oldPassword;
    @Password
    private String newPassword;
}
